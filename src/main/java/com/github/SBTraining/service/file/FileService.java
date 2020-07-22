package com.github.SBTraining.service.file;

import com.github.SBTraining.controller.file.FileRestController;
import com.github.SBTraining.dao.FileDao;
import com.github.SBTraining.model.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FileService {

    @Autowired
    private FileDao dao;

    static Logger log = Logger.getLogger(FileRestController.class.getName());

    public void uploadToDataBase(MultipartFile file) throws IOException {
        dao.save(new UserFile(file.getOriginalFilename(),file.getContentType(),file.getBytes()));
    }

    public List<UserFile> findAllFiles() {
        return dao.findAll();
    }

    public UserFile findFile(long id) {
        return dao.findById(id);
    }

}
