package com.example.clientuser.controller;

import com.alibaba.fastjson.JSON;
import com.example.clientuser.service.*;
import com.example.common.entity.JarDocument;
import com.example.common.entity.JarNew;
import com.example.common.entity.JarOld;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/14
 * Time: 13:44
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Controller
@RequestMapping("File")
public class FileUpload {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUserService redisUserService;
    @Autowired
    private PowerService powerService;
    @Value("${kindeditor.save.path}")
    private String savePath;
    @Value("${jar.upload.path}")
    private String jarPath;

    @Value("${static.resource.url}")
    private String staticServer;

    @Autowired
    private FileService fileService;

    @Autowired
    private MongodbService mongodbService;


    /*
     * ueditor图片保存
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public void umeditorUpload(@RequestParam("upfile") MultipartFile file, HttpServletResponse response) throws IOException {
        // System.out.println("我调用了fileUpload");
        JSONObject json = new JSONObject();
        // System.out.println(file.getOriginalFilename());
        //后缀
        String type = "." + file.getOriginalFilename().split("\\.")[1];
        // System.out.println(type);
        //根据时间获得图片的新名称
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String name = df.format(new Date()) + "_" + new Random().nextInt(1000) + type;
        //创建图片存放位置
        File newFile = new File(savePath + name);
        // System.out.println(newFile.getAbsolutePath());
        //回显地址-->localhost:8080/fileUpload
        String url = name;
        if (!newFile.exists()) {
            System.out.println("非空判断");
            json.put("state", "SUCCESS");
            json.put("original", file.getOriginalFilename());
            json.put("size", file.getSize());
            json.put("url", url);
            json.put("title", name);
            json.put("type", type);
        } else {
            json.put("state", "FALSE");
        }

        //第一次保存图片
        file.transferTo(newFile);
        //第二次target保存图片 : 注意：MultipartFile只能.transferTo一次 所以用文件复制的方式进行target添加.
        /**
         * 改为虚拟盘符
         */
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(json.toString());
        writer.close();
        System.out.println("保存本地图片成功！");
    }

    /*
     * 上传功能：测试
     * */
    @RequestMapping("jar/jarUploadJar")
    @ResponseBody
    public Boolean jarUploadJar(@RequestParam("jarName") String jarName, @RequestParam("uid") String uid,
                                @RequestParam("content") String content, @RequestParam("fileUpload") MultipartFile fileUpload,
                                @RequestParam("uname") String uname) throws IOException {
        Boolean bool = false;
        JarNew jarNew = null;
        JarOld jarOld = null;
        JarDocument jarDocument = null;
        Integer num = 0;
        Integer num2 = 0;
        Integer num3 = 0;
        Integer num4 = 0;
        Date date = new Date();
        String uuid = MakeUUID();
        System.out.println("UUID:::" + uuid);
       // System.out.println(fileUpload);
        if (content == null || content.length() == 0) {
            content = "No Supplementary Information For Jar";
        }
        if (jarName == null || jarName.length() == 0) {
            jarName = "No Title for Jar";
        }
        if (fileUpload == null || fileUpload.getSize() == 0) {
            System.out.println("文件为空");
            return bool;
        } else {
            /**
             * 开始保存JarNew表数据
             */
            //保存数据处理
            jarNew = new JarNew();
            jarNew.setJarName(jarName);
            jarNew.setJarPath_new(jarPath + fileUpload.getOriginalFilename());
            jarNew.setJarUploadTime(date);
            jarNew.setJarDowloadNumber(0);
            jarNew.setJarVersion("1.1");
            jarNew.setJarSize(ByteToMb(fileUpload.getSize()));
            jarNew.setUid(Integer.parseInt(uid));
            jarNew.setUname(uname);
            jarNew.setUuid(uuid);
            jarNew.setStatus("1");
            System.out.println("新增的JarNewUUID" + jarNew.getUuid());
            num = addOneJarNew(jarNew);
            if (num <= 0) {
                System.out.println("无法添加一个JarNew");
                return bool;
            }
            /**
             * 待留字段
             */
         /*   jarNew.setJarSkillOrientation("待留字段");
            jarNew.setJarIntroduce("待留字段");*/
            /**
             * 开始保存JarOld表数据
             */
            jarNew = fileService.selectJarNewByUUID(uuid);
            jarOld = new JarOld();
            jarOld.setJnID(jarNew.getJnID());
            jarOld.setJarName(jarNew.getJarName());
            jarOld.setJarPath_old(jarNew.getJarPath_new());
            jarOld.setJarUploadTime(jarNew.getJarUploadTime());
            jarOld.setJarDowloadNumber(jarNew.getJarDowloadNumber());
            jarOld.setJarVersion(jarNew.getJarVersion());
            jarOld.setJarSize(jarNew.getJarSize());
            jarOld.setUid(jarNew.getUid());
            jarOld.setUname(jarNew.getUname());
            jarOld.setUuid(jarNew.getUuid());
            jarOld.setStatus(jarNew.getStatus());
            //待留字段
          /*  jarOld.setJarSkillOrientation(jarNew.getJarSkillOrientation());
            jarOld.setJarIntroduce(jarNew.getJarIntroduce());*/

            num2 = fileService.saveOneJarInformation(null, jarOld);
            if (num2 <= 0) {
                System.out.println("无法添加一个JarOld");
                return bool;
            }

            /**
             * 开始保存JarDocument表数据
             */
            jarOld = fileService.selectJarOldByUUID(jarOld.getUuid());
            //System.out.println("得到新的jarOld" + jarOld);

            jarDocument = new JarDocument();
            jarDocument.setJoID(jarOld.getJoID());
            jarDocument.setJdUploadTime(jarOld.getJarUploadTime());
            jarDocument.setUuid(jarOld.getUuid());
            jarDocument.setStatus(jarOld.getStatus());
            num3 = fileService.saveJarDocument(jarDocument);
            if (num3 <= 0) {
                System.out.println("无法添加一个JarDicoment");
                return bool;
            }
            /**
             * 开始保存进Mongodb表数据
             */
            jarDocument = fileService.selectJarDocumentByUUID(jarDocument.getUuid());
            jarDocument.setDocument(content);
            //System.out.println("得到新的JarDocument" + jarDocument);
            num4 = mongodbService.addOneJarDocument(jarDocument);
            if (num4 <= 0) {
                System.out.println("mongodb无法添加一个document");
                return bool;
            }
            //保存文件
            //System.out.println("我准备保存文件了");
            File dest = new File(jarPath + fileUpload.getOriginalFilename());
            fileUpload.transferTo(dest);
            //System.out.println("保存成功！");
            bool = true;
        }
        return bool;
    }

    /**
     * 字节转Mb
     */
    public Double ByteToMb(Long byteSize) {
        int MB = 1024 * 1024;//定义MB的计算常量
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String resultSize = df.format(byteSize / (float) MB);
        double dnumber = Double.parseDouble(resultSize);
        if (dnumber == 0) {
            dnumber = 0.01;
        }
        return dnumber;
    }


    public Integer addOneJarNew(JarNew jarNew) {
        return fileService.saveOneJarInformation(jarNew, null);
    }

    public String MakeUUID() {
        UUID uuid = UUID.randomUUID();
        String uuNume = uuid.toString().replace("-", "");
        return uuNume;
    }

    /**
     * Jar包修改页面
     * @param jnID
     * @param model
     * @return
     */
    @RequestMapping("goto/iupdateJar")
    public String iupdateJar(@RequestParam("jnID") Integer jnID, Model model) {
        JarNew jarNew = fileService.getJarNewByJarID(jnID);
        model.addAttribute("staticServer", staticServer);
        model.addAttribute("jarNew", jarNew);
        return "iframe/iupdateJar";
    }

    /**
     * 文档修改页面
     * @param jnID
     * @param model
     * @return
     */
    @RequestMapping("goto/iupdateJarDocu")
    public String iupdateJarDocu(@RequestParam("jnID") Integer jnID, Model model) {
        JarNew jarNew = fileService.getJarNewByJarID(jnID);
        JarDocument jarDocument=mongodbService.findDocumentsByUUID(jarNew.getUuid()).get(0);
        model.addAttribute("staticServer", staticServer);
        model.addAttribute("jarNew", jarNew);
        model.addAttribute("jarDocument",jarDocument);
        return "iframe/iupdateJarDocu";
    }


    @RequestMapping("/find/allJarNew")
    public void getJarNews(HttpServletResponse resp) {
        List<JarNew> list = fileService.getJarNews();
        try {
            resp.setContentType("text/html;charset=utf8;");
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/find/selfJarNews")
    public void getSelfJarNews(HttpServletResponse resp, Integer uid) {
        List<JarNew> list = fileService.getSelfJarNews(uid, null, null);
        for (JarNew jarNew : list) {
            if (jarNew.getStatus().equals("0")) {
                jarNew.setStatus("已审核");
            } else if (jarNew.getStatus().equals("1")) {
                jarNew.setStatus("审核中");
            }
        }
        try {
            resp.setContentType("text/html;charset=utf8;");
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/find/manageJarNews")
    public void manageJarNews(HttpServletResponse resp) {
        List<JarNew> list = fileService.getSelfJarNews(null, null, null);
        if (list != null || list.size() != 0) {
            /**
             * 使用迭代器删除某个元素
             */
            ListIterator<JarNew> jarNewListIterator = list.listIterator();
            while (jarNewListIterator.hasNext()) {
                JarNew jarNew = jarNewListIterator.next();
                if (jarNew.getStatus().equals("1")) {
                    jarNewListIterator.remove();
                }
            }
        }
        try {
            resp.setContentType("text/html;charset=utf8;");
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/find/auditingJarNews")
    public void auditingJarNews(HttpServletResponse resp) {
        List<JarNew> list = fileService.getSelfJarNews(null, null, null);
        if (list != null || list.size() != 0) {
            /**
             * 使用迭代器删除某个元素
             */
            ListIterator<JarNew> jarNewListIterator = list.listIterator();
            while (jarNewListIterator.hasNext()) {
                JarNew jarNew = jarNewListIterator.next();
                if (jarNew.getStatus().equals("0")) {
                    jarNewListIterator.remove();
                }
            }
        }
        try {
            resp.setContentType("text/html;charset=utf8;");
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("lookJar")
    public String LookJar(Integer jnID, Model model) {
        JarNew jarNew = fileService.getJarNewByJarID(jnID);
        List<JarDocument> jarDocuments = mongodbService.findDocumentsByUUID(jarNew.getUuid());
        JarDocument jarDocument = jarDocuments.get(0);
        List<JarOld> jarOlds = fileService.getAllJarOldByJnID(jnID);
        model.addAttribute("jarNew", jarNew);
        model.addAttribute("jarDocument", jarDocument);
        model.addAttribute("jarOlds", jarOlds);
        return "iframe/lookJar";
    }

    @RequestMapping("returnJar")
    public String returnJar(Integer joID, Model model) {
        JarOld jarOld = fileService.getJarOldByJoID(joID);
        List<JarDocument> jarDocuments = mongodbService.findDocumentsByJod(joID);
        JarDocument jarDocument = jarDocuments.get(0);
        List<JarOld> jarOlds = fileService.getAllJarOldByJnID(jarOld.getJnID());
        /**
         * 使用迭代器删除某个元素
         */
        ListIterator<JarOld> jarOldListIterator = jarOlds.listIterator();
        while (jarOldListIterator.hasNext()) {
            JarOld jarOld1 = jarOldListIterator.next();
            if (jarOld1.getJoID().equals(joID)) {
                jarOldListIterator.remove();
            }
        }
        model.addAttribute("jarOld", jarOld);
        model.addAttribute("jarDocument", jarDocument);
        model.addAttribute("jarOlds", jarOlds);
        return "iframe/returnJar";
    }


    @RequestMapping("checkView")
    public String checkView(Integer jnID, Model model) {
        JarNew jarNew = fileService.getJarNewByJarID(jnID);
        List<JarDocument> jarDocuments = mongodbService.findDocumentsByUUID(jarNew.getUuid());
        JarDocument jarDocument = jarDocuments.get(0);
        model.addAttribute("jarNew", jarNew);
        model.addAttribute("jarDocument", jarDocument);
        return "iframe/checkView";
    }

    @RequestMapping(value = "straw", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> straw(@RequestParam("jnID") Integer jnID) {
        Map<String, String> map = new HashMap<>();
        Integer num = fileService.updateStatus(jnID);
        JarNew jarNew = fileService.getJarNewByJarID(jnID);
        Integer num2 = fileService.updateJarOldStatus(jarNew.getUuid());
        Integer num3 = fileService.updateJarDocumentStatus(jarNew.getUuid());
        if (num > 0 && num2 > 0 && num3 > 0) {
            map.put("info", "已批准");
        } else {
            map.put("info", "批准异常");
        }
        return map;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(@RequestParam("jnID") Integer jnID) {
        Map<String, String> map = new HashMap<>();
        List<JarOld> jarOlds = fileService.getAllJarOldByJnID(jnID);
        List<Integer> joIDs = new ArrayList<>();
        for (JarOld jarOld : jarOlds) {
            joIDs.add(jarOld.getJoID());
        }
        Integer num1 = fileService.deleteJnID(jnID);
        Integer num2 = fileService.deleteJoIDs(joIDs);
        if (num1 > 0 && num2 > 0) {
            map.put("info", "删除成功");
        } else {
            map.put("info", "删除异常");
        }
        return map;
    }
}
