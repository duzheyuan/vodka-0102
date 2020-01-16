package com.example.mongodbserver.controller;

import com.example.common.entity.JarDocument;
import com.example.mongodbserver.dao.mongodbUserDao;
import com.example.mongodbserver.service.mongodbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class mongodbUserController {

    @Autowired
    private mongodbUserServiceImpl mongodbUserService;

    @GetMapping("mongo/find/documents")
    public List<JarDocument> findAllDocuments() {
        return mongodbUserService.findAllDocuments();
    }

    @GetMapping("mongo/find/documents/joID")
    public List<JarDocument> findDocumentsByJod(@RequestParam("joID") Integer joID) {
        return mongodbUserService.findDocumentsByJod(joID);
    }


    @PostMapping("mongo/add/document")
    public Integer addOneJarDocument(@RequestBody JarDocument jarDocument) {
        mongodbUserService.insertOneJarDocument(jarDocument);
        return 1;
    }

    @GetMapping("mongo/find/documents/uuid")
    public List<JarDocument> findDocumentsByUUID(@RequestParam("uuid") String uuid) {
        return mongodbUserService.findDocumentsByUUID(uuid);
    }
    @PostMapping("mongo/set/contentByuuid")
    void setJarDocumentContentByUUID(@RequestParam("uuid") String uuid,@RequestParam("content") String content){
        mongodbUserService.setJarDocumentContentByUUID(uuid,content);
    }
}
