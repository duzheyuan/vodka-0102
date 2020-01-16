package com.example.fileserver.service;

import com.example.common.entity.JarNew;
import com.example.fileserver.mapper.JarNewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/3
 * Time: 15:54
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class JarNewServiceImpl implements JarNewService {
    @Autowired
    private JarNewMapper jarNewMapper;

    @Override
    public Integer saveOneJarNew(JarNew jarNew) {
        return jarNewMapper.insertOneJarNew(jarNew);
    }

    @Override
    public JarNew getJarByJnID(Integer jnID) {
        return jarNewMapper.selectJarByJnID(jnID);
    }

    @Override
    public JarNew selectJarNewByUUID(String UUID) {
        return jarNewMapper.selectJarNewByUUID(UUID);
    }

    @Override
    public List<JarNew> getJarNews() {
        return jarNewMapper.selectJarNews();
    }

    @Override
    public List<JarNew> selectSelfJarNews(Integer uid, String uname, String uuid) {
        return jarNewMapper.selectSelfJarNews(uid, uname, uuid);
    }

    @Override
    public Integer updateStatus(Integer jnID) {
        return jarNewMapper.updateStatus(jnID);
    }

    @Override
    public Integer deleteJarNewByJnID(Integer jnID) {
        return jarNewMapper.deleteJarNewByJnID(jnID);
    }

    @Override
    public Integer updateJarNew(JarNew jarNew) {
        return jarNewMapper.updateJarNew(jarNew);
    }

}
