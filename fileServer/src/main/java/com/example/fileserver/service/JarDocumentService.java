package com.example.fileserver.service;

import com.example.common.entity.JarDocument;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/4
 * Time: 16:56
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface JarDocumentService {
    Integer saveOneJarDocument(JarDocument jarDocument);

    JarDocument selectJarDocumentByUUID(String UUID);

    Integer updateJarDocumentStatus(String uuid);
}
