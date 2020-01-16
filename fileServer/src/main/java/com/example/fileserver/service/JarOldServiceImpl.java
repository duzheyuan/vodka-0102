package com.example.fileserver.service;

import com.example.common.entity.JarOld;
import com.example.fileserver.mapper.JarOldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/3
 * Time: 16:05
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class JarOldServiceImpl implements JarOldService {
    @Autowired
    private JarOldMapper jarOldMapper;

    @Override
    public Integer saveOneJarOld(JarOld jarOld) {
        return jarOldMapper.insertOneJarOld(jarOld);
    }

    @Override
    public JarOld selectJarOldByUUID(String UUID) {
        return jarOldMapper.selectJarOldByUUID(UUID);
    }

    @Override
    public List<JarOld> getAllJarOldByJnID(Integer jnID) {
        return jarOldMapper.selectAllJarOldByJnID(jnID);
    }

    @Override
    public JarOld getJarOldByJoID(Integer joID) {
        return jarOldMapper.selectJarOldByJoID(joID);
    }

    @Override
    public Integer deleteJarOldsByIDs(List<Integer> joIDs) {
        return jarOldMapper.deleteJarOldsByIDs(joIDs);
    }

    @Override
    public Integer updateJarOldStatus(String uuid) {
        return jarOldMapper.updateJarOldStatus(uuid);
    }


}
