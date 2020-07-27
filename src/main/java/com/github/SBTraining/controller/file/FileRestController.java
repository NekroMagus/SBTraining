package com.github.SBTraining.controller.file;

import com.github.SBTraining.model.UserFile;
import com.github.SBTraining.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Egor Odintsov
 */

@RestController
public class FileRestController {

    static Logger log = Logger.getLogger(FileRestController.class.getName());

    @Autowired
    private FileService service;

    /**
     * method which upload files on server
     *
     * @param file - file which will upload on server
     * @return responseEntity object which contains message and http status
     */

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            service.uploadToDataBase(file);
            log.info("file " + file.getOriginalFilename() + " saved");
            return new ResponseEntity("file saved", HttpStatus.OK);
        } else {
            log.info("file is not exists or is empty");
            return new ResponseEntity("file didnt saved", HttpStatus.OK);
        }
    }

    @GetMapping("/getAllFiles")
    public List<UserFile> getAllFiles() {
        return service.findAllFiles();
    }

    @GetMapping("/file/{id}")
    public UserFile findFile(@PathVariable("id") long id) {
        return service.findFile(id);
    }

}
