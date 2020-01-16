package com.example.fileserver.mapper;

import com.example.common.entity.JarOld;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/3
 * Time: 15:56
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Mapper
public interface JarOldMapper {
    //插入一条数据
    Integer insertOneJarOld(JarOld jarOld);

    //根据存取地址获得（存取地址+名称是唯一的）
    JarOld selectJarOldByUUID(String uuid);

    JarOld selectJarOldByJoID(Integer joID);

    List<JarOld> selectAllJarOldByJnID(Integer jnID);

    Integer deleteJarOldsByIDs(List<Integer> joIDs);

    Integer updateJarOldStatus(String uuid);
}
