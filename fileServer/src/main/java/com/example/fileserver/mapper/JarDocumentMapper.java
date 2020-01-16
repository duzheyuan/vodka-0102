package com.example.fileserver.mapper;

import com.example.common.entity.JarDocument;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/4
 * Time: 16:53
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Mapper
public interface JarDocumentMapper {
    Integer insertOneJarDocument(JarDocument jarDocument);

    JarDocument selectJarDocumentByUUID(String uuid);

    Integer updateJarDocumentStatus(String uuid);
}
