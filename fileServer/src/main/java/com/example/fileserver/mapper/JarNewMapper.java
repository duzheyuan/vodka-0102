package com.example.fileserver.mapper;

import com.example.common.entity.JarNew;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/3
 * Time: 15:46
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Mapper
public interface JarNewMapper {
    //查找一条数据通过JnID
    JarNew selectJarByJnID(Integer jnID);

    //插入一条数据
    Integer insertOneJarNew(JarNew jarNew);

    //根据存取地址获得（存取地址+名称是唯一的）
    JarNew selectJarNewByUUID(String uuid);

    List<JarNew> selectJarNews();

    List<JarNew> selectSelfJarNews(Integer uid, String uname, String uuid);

    Integer updateStatus(Integer jnID);

    Integer deleteJarNewByJnID(Integer jnID);

    Integer updateJarNew(JarNew jarNew);
}
