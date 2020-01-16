package com.example.clientuser.dao;

import com.example.common.entity.JarDocument;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/4
 * Time: 16:38
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
@FeignClient(value = "mongodb-server")
public interface MongodbDao {

    @GetMapping("mongo/find/documents")
    List<JarDocument> findAllDocuments();

    //未知
    @GetMapping("mongo/find/documents/joID")
    List<JarDocument> findDocumentsByJod(@RequestParam("joID") Integer joID);

    @PostMapping("mongo/add/document")
    Integer addOneJarDocument(@RequestBody JarDocument jarDocument);


    @GetMapping("mongo/find/documents/uuid")
    List<JarDocument> findDocumentsByUUID(@RequestParam("uuid") String uuid);

    @PostMapping("mongo/set/contentByuuid")
    void setJarDocumentContentByUUID(@RequestParam("uuid") String uuid,@RequestParam("content") String content);
}
