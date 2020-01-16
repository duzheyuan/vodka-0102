package com.example.clientuser.service;

import com.example.clientuser.dao.MongodbDao;
import com.example.common.entity.JarDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/4
 * Time: 16:42
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
@RestController
public class MongodbServiceImpl implements MongodbService {
    @Autowired
    private MongodbDao mongodbDao;

    @Override
    public List<JarDocument> findAllDocuments() {
        return mongodbDao.findAllDocuments();
    }

    @Override
    @RequestMapping("indexxx")
    public List<JarDocument> findDocumentsByJod(Integer joID) {
        return mongodbDao.findDocumentsByJod(joID);
    }

    @Override
    public Integer addOneJarDocument(JarDocument jarDocument) {
        Integer num = mongodbDao.addOneJarDocument(jarDocument);
        return num;
    }

    @Override
    public List<JarDocument> findDocumentsByUUID(String uuid) {
        return mongodbDao.findDocumentsByUUID(uuid);
    }

    @Override
    public void setJarDocumentContentByUUID(String uuid, String content) {
        mongodbDao.setJarDocumentContentByUUID(uuid,content);
    }
}
