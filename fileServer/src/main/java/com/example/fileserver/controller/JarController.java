package com.example.fileserver.controller;

import com.example.common.entity.JarDocument;
import com.example.common.entity.JarNew;
import com.example.common.entity.JarOld;
import com.example.fileserver.service.JarDocumentService;
import com.example.fileserver.service.JarNewService;
import com.example.fileserver.service.JarOldService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/15
 * Time: 11:48
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@RestController
public class JarController {
    @Autowired
    private JarNewService jarNewService;
    @Autowired
    private JarOldService jarOldService;

    @Autowired
    private JarDocumentService jarDocumentService;


    @GetMapping("jarNew/{jnID}")
    public JarNew getJarNewByJarID(@PathVariable("jnID") Integer jnID) {
        return jarNewService.getJarByJnID(jnID);
    }


    @GetMapping("jarNew/findAll")
    public List<JarNew> getJarNews() {
        return jarNewService.getJarNews();
    }

    @PostMapping("jar/insert")
    public Integer saveOneJarInformation(@RequestBody Map<String, Object> jars) {
        /*       System.out.println("传过去了！！");*/

        JarNew jarNew = JSONObjectMakeObjectToBean(jars.get("jarNew"));
        JarOld jarOld = JSONObjectMakeObjectToBean2(jars.get("jarOld"));


        Integer num = 0;
        if (jarNew == null && jarOld == null) {
            System.out.println("0");
            return num;
        }


        if (jarNew == null) {
            System.out.println("1");
            num = jarOldService.saveOneJarOld(jarOld);
        }

        if (jarOld == null) {
            System.out.println("2");
            num = jarNewService.saveOneJarNew(jarNew);
        }
        return num;
    }

    @GetMapping("jar/select/selectJarNewByUUID")
    public JarNew selectJarNewByUUID(@RequestParam("UUID") String UUID) {
        return jarNewService.selectJarNewByUUID(UUID);
    }

    @GetMapping("jar/select/JarOldByUUID")
    public JarOld selectJarOldByUUID(@RequestParam("UUID") String UUID) {
        return jarOldService.selectJarOldByUUID(UUID);
    }

    @GetMapping("document/select/JarDocumentByUUID")
    JarDocument selectJarDocumentByUUID(@RequestParam("UUID") String UUID) {
        return jarDocumentService.selectJarDocumentByUUID(UUID);
    }

    /**
     * 解决LinkHashMap里面的Object不能直接强制转化为Bean
     * Object-->json
     * json转换为(Bean)Object
     */
    public JarNew JSONObjectMakeObjectToBean(Object object) {
        JSONObject json = JSONObject.fromObject(object);
        Object obj = JSONObject.toBean(json, JarNew.class);
        JarNew jarNew = (JarNew) obj;
        return jarNew;
    }

    public JarOld JSONObjectMakeObjectToBean2(Object object) {
        JSONObject json = JSONObject.fromObject(object);
        Object obj = JSONObject.toBean(json, JarOld.class);
        JarOld jarOld = (JarOld) obj;
        return jarOld;
    }

    @PostMapping("document/insert")
    public Integer saveJarDocument(@RequestBody JarDocument jarDocument) {
        return jarDocumentService.saveOneJarDocument(jarDocument);
    }

    @GetMapping("jarNew/findSelfJarNews")
    public List<JarNew> selectSelfJarNews(@RequestParam(value = "uid", required = false) Integer uid, @RequestParam(value = "uname", required = false) String uname, @RequestParam(value = "uuid", required = false) String uuid) {
        return jarNewService.selectSelfJarNews(uid, uname, uuid);
    }

    @GetMapping("jarOld/getAllJarOldByJnID")
    public List<JarOld> getAllJarOldByJnID(@RequestParam("jnID") Integer jnID) {
        return jarOldService.getAllJarOldByJnID(jnID);
    }

    @GetMapping("jarOld/getJarOldByJoID")
    public JarOld getJarOldByJoID(@RequestParam("joID") Integer joID) {
        return jarOldService.getJarOldByJoID(joID);
    }

    @PostMapping("jarNew/updateStatus")
    public Integer updateStatus(@RequestParam("jnID") Integer jnID) {
        return jarNewService.updateStatus(jnID);
    }

    @DeleteMapping("jarNew/delete/jnID")
    public Integer deleteJnID(@RequestParam("jnID") Integer jnID) {
        return jarNewService.deleteJarNewByJnID(jnID);
    }

    @DeleteMapping("jarOld/delete/joIDs")
    public Integer deleteJoIDs(@RequestParam("joIDs") List<Integer> joIDs) {
        return jarOldService.deleteJarOldsByIDs(joIDs);
    }

    @PostMapping("updateJarNew")
    public Integer updateJarNew(@RequestBody JarNew jarNew) {
        return jarNewService.updateJarNew(jarNew);
    }

    @PostMapping("updateJarOldStatus")
    public Integer updateJarOldStatus(@RequestParam("uuid") String uuid) {
        return jarOldService.updateJarOldStatus(uuid);
    }

    @PostMapping("updateJarDocumentStatus")
    public Integer updateJarDocumentStatus(@RequestParam("uuid") String uuid) {
        return jarDocumentService.updateJarDocumentStatus(uuid);
    }
}
