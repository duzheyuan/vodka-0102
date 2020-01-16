package com.example.mongodbserver.service;

import com.example.common.entity.JarDocument;

import java.util.List;

public interface mongodbUserService {

    //查找所有的JarDocument（不分Jar包版本）
    List<JarDocument> findAllDocuments();
    //获得指定Jar包版本的所有Document
    List<JarDocument> findDocumentsByJod(Integer joID);

    void insertOneJarDocument(JarDocument jarDocument);
    List<JarDocument> findDocumentsByUUID(String uuid);
    void setJarDocumentContentByUUID(String uuid,String content);
}
