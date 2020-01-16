package com.example.fileserver.service;

import com.example.common.entity.JarOld;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/3
 * Time: 16:04
 * Description: No Description
 *
 * @author:ZhouRunLin
 */

public interface JarOldService {
    //插入一条数据
    Integer saveOneJarOld(JarOld jarOld);

    JarOld selectJarOldByUUID(String UUID);

    List<JarOld> getAllJarOldByJnID(Integer jnID);

    JarOld getJarOldByJoID(Integer joID);

    Integer deleteJarOldsByIDs(List<Integer> joIDs);

    Integer updateJarOldStatus(String uuid);
}
