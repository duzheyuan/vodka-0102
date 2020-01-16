package com.example.clientuser.service;

import com.example.common.entity.JarDocument;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/4
 * Time: 16:42
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface MongodbService {
    List<JarDocument> findAllDocuments();

    //未知
    List<JarDocument> findDocumentsByJod(Integer joID);

    Integer addOneJarDocument(JarDocument jarDocument);

    List<JarDocument> findDocumentsByUUID(String uuid);

    void setJarDocumentContentByUUID(String uuid, String content);
}
