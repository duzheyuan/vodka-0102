package com.example.fileserver.service;

import com.example.common.entity.JarNew;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/3
 * Time: 15:53
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface JarNewService {
    //插入一条数据
    Integer saveOneJarNew(JarNew jarNew);

    JarNew getJarByJnID(Integer jnID);

    JarNew selectJarNewByUUID(String UUID);

    List<JarNew> getJarNews();

    List<JarNew> selectSelfJarNews(Integer uid, String uname, String uuid);

    Integer updateStatus(Integer jnID);

    Integer deleteJarNewByJnID(Integer jnID);

    Integer updateJarNew(JarNew jarNew);
}
