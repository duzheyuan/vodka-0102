package com.example.mongodbserver.service;

import com.example.common.entity.JarDocument;
import com.example.mongodbserver.dao.mongodbUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mongodbUserServiceImpl implements mongodbUserService {

    @Autowired
    private mongodbUserDaoImpl mongodbUserDao;

    @Override
    public List<JarDocument> findAllDocuments() {
        return mongodbUserDao.findAllDocuments();
    }

    @Override
    public List<JarDocument> findDocumentsByJod(Integer joID) {
        return mongodbUserDao.findDocumentsByJod(joID);
    }

    @Override
    public void insertOneJarDocument(JarDocument jarDocument) {
        mongodbUserDao.insertOneJarDocument(jarDocument);
    }

    @Override
    public List<JarDocument> findDocumentsByUUID(String uuid) {
        return mongodbUserDao.findDocumentsByUUID(uuid);
    }

    @Override
    public void setJarDocumentContentByUUID(String uuid, String content) {
        mongodbUserDao.updateJarDocumentContentByUUID(uuid,content);
    }
}
