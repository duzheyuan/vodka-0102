package com.example.clientuser.dao;

import com.example.common.entity.JarDocument;
import com.example.common.entity.JarNew;
import com.example.common.entity.JarOld;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/15
 * Time: 11:58
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
@FeignClient(value = "file-server")
public interface FileDao {
    @GetMapping("jarNew/{jnID}")
    JarNew getJarNewByJarID(@PathVariable("jnID") Integer jnID);

    @PostMapping("jar/insert")
    Integer saveOneJarInformation(@RequestBody Map<String, Object> jars);


    @PostMapping("document/insert")
    Integer saveJarDocument(@RequestBody JarDocument jarDocument);

    @GetMapping("jar/select/selectJarNewByUUID")
    JarNew selectJarNewByUUID(@RequestParam("UUID") String UUID);

    @GetMapping("jar/select/JarOldByUUID")
    JarOld selectJarOldByUUID(@RequestParam("UUID") String UUID);

    @GetMapping("document/select/JarDocumentByUUID")
    JarDocument selectJarDocumentByUUID(@RequestParam("UUID") String UUID);

    @GetMapping("jarNew/findAll")
    List<JarNew> getJarNews();

    @GetMapping("jarNew/findSelfJarNews")
    List<JarNew> selectSelfJarNews(@RequestParam(value = "uid", required = false) Integer uid, @RequestParam(value = "uname", required = false) String uname, @RequestParam(value = "uuid", required = false) String uuid);

    @GetMapping("jarOld/getAllJarOldByJnID")
    List<JarOld> getAllJarOldByJnID(@RequestParam("jnID") Integer jnID);

    @GetMapping("jarOld/getJarOldByJoID")
    JarOld getJarOldByJoID(@RequestParam("joID") Integer joID);

    @PostMapping("jarNew/updateStatus")
    Integer updateStatus(@RequestParam("jnID") Integer jnID);

    @DeleteMapping("jarNew/delete/jnID")
    Integer deleteJnID(@RequestParam("jnID") Integer jnID);

    @DeleteMapping("jarOld/delete/joIDs")
    Integer deleteJoIDs(@RequestParam("joIDs") List<Integer> joIDs);

    @PostMapping("updateJarNew")
    Integer updateJarNew(@RequestBody JarNew jarNew);

    @PostMapping("updateJarOldStatus")
    Integer updateJarOldStatus(@RequestParam("uuid") String uuid);

    @PostMapping("updateJarDocumentStatus")
    Integer updateJarDocumentStatus(@RequestParam("uuid") String uuid);
}
