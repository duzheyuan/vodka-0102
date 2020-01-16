package com.example.clientuser.controller;

import com.example.clientuser.service.FileService;
import com.example.clientuser.service.MongodbService;
import com.example.common.entity.JarDocument;
import com.example.common.entity.JarNew;
import com.example.common.entity.JarOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/26
 * Time: 11:29
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Controller
@RequestMapping("JarCrud")
public class JarDowload extends HttpServlet {
    @Autowired
    private FileService fileService;

    @Value("${jar.upload.path}")
    private String jarPath;
    @Autowired
    private MongodbService mongodbService;

    @RequestMapping(value = "downJar", method = RequestMethod.GET)
    @ResponseBody
    public void downJar(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Integer jnID = null;
        Integer joID = null;
        String jnIDStr = null;
        String joIDStr = null;
        jnIDStr = request.getParameter("jnID");
        joIDStr = request.getParameter("joID");
        String filePath = null;
        if (jnIDStr != null) {
            jnID = Integer.parseInt(jnIDStr);
            JarNew jarNew = fileService.getJarNewByJarID(jnID);
            filePath = jarNew.getJarPath_new();
        } else if (joIDStr != null) {
            joID = Integer.parseInt(joIDStr);
            JarOld jarOld = fileService.getJarOldByJoID(joID);
            filePath = jarOld.getJarPath_old();
        }
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String prefix = fileName.substring(0, fileName.lastIndexOf("."));
        File file = new File(filePath);
        //告诉浏览器以附件形式下载。
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(prefix.getBytes
                ("GB2312"), "8859_1") + suffix);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //文件大小
        response.setHeader("Content-Length", String.valueOf(file.length()));
        //获取response的输出流，输出文件
        ServletOutputStream out = response.getOutputStream();
        //以输入流的形式读取文件
        FileInputStream in = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        in.close();
    }

    /**
     * 文档更新
     *
     * @param fileUpload
     * @param jnID
     * @param jarName
     * @return
     * @throws IOException
     */
    @RequestMapping("jarUpdate")
    @ResponseBody
    public Boolean jarUpdate(@RequestParam(value = "fileUpload", required = false) MultipartFile fileUpload, @RequestParam("jnID") Integer jnID,
                             @RequestParam("jarName") String jarName, @RequestParam(value = "content", required = false) String content) throws IOException {
        Boolean bool = null;
        JarNew jarNew = null;
        JarOld jarOld = null;
        /**
         * 修改文档Or修改Jar包
         */
        Integer numSwitch = 2;
        if (content != null) {
            numSwitch = 1;
        } else if (fileUpload != null) {
            numSwitch = 0;
        }
        switch (numSwitch) {
            //修改Jar包
            case 0:
                jarNew = fileService.getJarNewByJarID(jnID);
                Date date = new Date();
                /**
                 * 获得旧UUID
                 */
                String jarOldUUIDLast = jarNew.getUuid();

                /**
                 * 更新JarNew
                 */
                String uuid = MakeUUID();
                jarNew.setJarName(jarName);
                jarNew.setJarUploadTime(date);
                jarNew.setJarPath_new(jarPath + fileUpload.getOriginalFilename());
                jarNew.setJarSize(ByteToMb(fileUpload.getSize()));
                jarNew.setUuid(uuid);
                jarNew.setJarDowloadNumber(0);
                String version = jarNew.getJarVersion();
                String versionPointNum = version.substring(version.lastIndexOf(".") + 1);
                Integer pointNum = Integer.parseInt(versionPointNum);
                Integer preNum = Integer.parseInt(version.substring(0, version.lastIndexOf(".")));
                if (pointNum == 9) {
                    preNum = preNum + 1;
                    pointNum = 1;
                    version = preNum + "." + pointNum;
                } else {
                    pointNum = pointNum + 1;
                    version = preNum + "." + pointNum;
                }
                jarNew.setJarVersion(version);
                Integer num = fileService.updateJarNew(jarNew);
                if (num > 0) {
                    /**
                     * 增加新的JarOld
                     */
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
                    Integer num2 = fileService.saveOneJarInformation(null, jarOld);
                    if (num2 > 0) {
                        /**
                         * 得到新的JarOld
                         */
                        jarOld = fileService.selectJarOldByUUID(jarOld.getUuid());

                        /**
                         * 复制一份JarDocument
                         * 第一步：先获得旧JarDocuemnt
                         * 第二步：新增JarDocument
                         * 第三步：复制到MongoDB中
                         */
                        List<JarDocument> jarDocumentOldList = mongodbService.findDocumentsByUUID(jarOldUUIDLast);
                        JarDocument jarDocumentOld = jarDocumentOldList.get(0);
                        /**
                         * 新增新JarDocument
                         */
                        JarDocument jarDocument = new JarDocument();
                        jarDocument.setJoID(jarOld.getJoID());
                        jarDocument.setUuid(jarOld.getUuid());
                        jarDocument.setStatus(jarOld.getStatus());
                        jarDocument.setJdUploadTime(jarOld.getJarUploadTime());
                        jarDocument.setJdPath(jarDocumentOld.getJdPath());
                        Integer num3 = fileService.saveJarDocument(jarDocument);
                        if (num3 > 0) {
                            /**
                             * 获得最新的JarDocument行数据
                             */
                            jarDocument = fileService.selectJarDocumentByUUID(jarDocument.getUuid());
                            jarDocument.setDocument(jarDocumentOld.getDocument());
                            /**
                             * 新增一个JarDocument
                             */
                            Integer num4 = mongodbService.addOneJarDocument(jarDocument);
                            if (num4 > 0) {
                                /**
                                 * 数据库准备就绪，复制文件
                                 */
                                File dest = new File(jarPath + fileUpload.getOriginalFilename());
                                fileUpload.transferTo(dest);
                                bool = true;
                            }
                        }

                    }
                }
                break;
            case 1:
                //修改文档
                jarNew = fileService.getJarNewByJarID(jnID);
                mongodbService.setJarDocumentContentByUUID(jarNew.getUuid(), content);
                bool = true;
                break;
            case 2:
                bool = false;
                break;
            default:
                bool = false;
                break;
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

    public String MakeUUID() {
        UUID uuid = UUID.randomUUID();
        String uuNume = uuid.toString().replace("-", "");
        return uuNume;
    }

}
