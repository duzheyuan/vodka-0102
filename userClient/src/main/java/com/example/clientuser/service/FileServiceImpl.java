package com.example.clientuser.service;

import com.example.clientuser.dao.FileDao;
import com.example.common.entity.JarDocument;
import com.example.common.entity.JarNew;
import com.example.common.entity.JarOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/15
 * Time: 14:09
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public JarNew getJarNewByJarID(Integer jnID) {
        return fileDao.getJarNewByJarID(jnID);
    }

    @Override
    public Integer saveOneJarInformation(JarNew jarNew, JarOld jarOld) {
        Map<String, Object> jars = new HashMap<>();
        jars.put("jarNew", jarNew);
        jars.put("jarOld", jarOld);
        return fileDao.saveOneJarInformation(jars);
    }





    @Override
    public Integer saveJarDocument(JarDocument jarDocument) {
        return fileDao.saveJarDocument(jarDocument);
    }

    @Override
    public JarNew selectJarNewByUUID(String UUID) {
        return fileDao.selectJarNewByUUID(UUID);
    }

    @Override
    public JarOld selectJarOldByUUID(String UUID) {
        return fileDao.selectJarOldByUUID(UUID);
    }

    @Override
    public JarDocument selectJarDocumentByUUID(String UUID) {
        return fileDao.selectJarDocumentByUUID(UUID);
    }


    @Override
    public List<JarNew> getJarNews() {
        return fileDao.getJarNews();
    }

    @Override
    public List<JarNew> getSelfJarNews(Integer uid, String uname, String uuid) {
        return fileDao.selectSelfJarNews(uid,uname,uuid);
    }

    @Override
    public List<JarOld> getAllJarOldByJnID(Integer jnID) {
        return fileDao.getAllJarOldByJnID(jnID);
    }

    @Override
    public JarOld getJarOldByJoID(Integer joID) {
        return fileDao.getJarOldByJoID(joID);
    }

    @Override
    public Integer updateStatus(Integer jnID) {
        return fileDao.updateStatus(jnID);
    }

    @Override
    public Integer deleteJnID(Integer jnID) {
        return fileDao.deleteJnID(jnID);
    }

    @Override
    public Integer deleteJoIDs(List<Integer> joIDs) {
        return fileDao.deleteJoIDs(joIDs);
    }

    @Override
    public Integer updateJarNew(JarNew jarNew) {
        return fileDao.updateJarNew(jarNew);
    }

    @Override
    public Integer updateJarOldStatus(String uuid) {
        return fileDao.updateJarOldStatus(uuid);
    }

    @Override
    public Integer updateJarDocumentStatus(String uuid) {
        return fileDao.updateJarDocumentStatus(uuid);
    }


}
