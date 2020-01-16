package com.example.clientuser.service;

import com.example.common.entity.JarDocument;
import com.example.common.entity.JarNew;
import com.example.common.entity.JarOld;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/15
 * Time: 14:08
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface FileService {
    JarNew getJarNewByJarID(Integer jnID);

    Integer saveOneJarInformation(JarNew jarNew, JarOld jarOld);


    Integer saveJarDocument(JarDocument jarDocument);

    JarNew selectJarNewByUUID(String UUID);

    JarOld selectJarOldByUUID(String UUID);

    JarDocument selectJarDocumentByUUID(String UUID);

    List<JarNew> getJarNews();

    List<JarNew> getSelfJarNews(Integer uid, String uname, String uuid);

    List<JarOld> getAllJarOldByJnID(Integer jnID);

    JarOld getJarOldByJoID(Integer joID);

    Integer updateStatus(Integer jnID);

    Integer deleteJnID(Integer jnID);

    Integer deleteJoIDs(List<Integer> joIDs);

    Integer updateJarNew(JarNew jarNew);

    Integer updateJarOldStatus(String uuid);

    Integer updateJarDocumentStatus(String uuid);

}
