package com.example.mongodbserver.dao;


import com.example.common.entity.JarDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class mongodbUserDaoImpl implements mongodbUserDao {
    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<JarDocument> findAllDocuments() {
        Query query = new Query();
        /*   query.with(new Sort(Sort.Direction.DESC , "insertTime"));*/
        return mongoTemplate.findAll(JarDocument.class);
    }

    @Override
    public List<JarDocument> findDocumentsByJod(Integer joID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("joID").is(joID));
        List<JarDocument> jarDocuments= mongoTemplate.find(query, JarDocument.class);
        return jarDocuments;
    }

    @Override
    public List<JarDocument> findDocumentsByUUID(String uuid) {
        Query query=new Query();
        query.addCriteria(Criteria.where("uuid").is(uuid));
        List<JarDocument> jarDocuments=mongoTemplate.find(query,JarDocument.class);
        return jarDocuments;
    }

    @Override
    public void insertOneJarDocument(JarDocument jarDocument) {
        mongoTemplate.insert(jarDocument);
    }

    @Override
    public void updateJarDocumentContentByUUID(String uuid,String content) {
        Query query=new Query();
        query.addCriteria(Criteria.where("uuid").is(uuid));
        Update update=Update.update("document",content);
        mongoTemplate.upsert(query,update,JarDocument.class);
    }
}
