package com.example.fileserver.service;

import com.example.common.entity.JarDocument;
import com.example.fileserver.mapper.JarDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/4
 * Time: 16:56
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class JarDocumentServiceImpl implements JarDocumentService {
    @Autowired
    private JarDocumentMapper jarDocumentMapper;

    @Override
    public Integer saveOneJarDocument(JarDocument jarDocument) {
        return jarDocumentMapper.insertOneJarDocument(jarDocument);
    }

    @Override
    public JarDocument selectJarDocumentByUUID(String UUID) {
        return jarDocumentMapper.selectJarDocumentByUUID(UUID);
    }

    @Override
    public Integer updateJarDocumentStatus(String uuid) {
        return jarDocumentMapper.updateJarDocumentStatus(uuid);
    }


}
