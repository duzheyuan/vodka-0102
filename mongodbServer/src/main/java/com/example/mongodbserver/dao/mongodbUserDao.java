package com.example.mongodbserver.dao;

import com.example.common.entity.JarDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface mongodbUserDao {


    //查找所有的JarDocument（不分Jar包版本）
    List<JarDocument> findAllDocuments();
    //获得指定Jar包版本的Document
    List<JarDocument> findDocumentsByJod(Integer joID);

    List<JarDocument> findDocumentsByUUID(String uuid);

    void insertOneJarDocument(JarDocument jarDocument);

    void updateJarDocumentContentByUUID(String uuid,String content);

}
