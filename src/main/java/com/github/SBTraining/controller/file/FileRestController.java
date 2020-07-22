package com.github.SBTraining.controller.file;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.logging.Logger;

/**
 * @author Egor Odintsov
 */

@RestController
public class FileRestController {

    static Logger log = Logger.getLogger(FileRestController.class.getName());

    /**
     * method which upload files on server
     * @param file - file which will upload on server
     * @return responseEntity object which contains message and http status
     */

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam MultipartFile file) {
        String uploadPath = "./uploadPath";
        File path = new File(uploadPath);
        if(path.exists())
           path.mkdir();
        long randomId = (long) (Math.random() * 1000000000);
        if(file!=null || file.isEmpty()) {
            File userFile = new File(uploadPath + "/" + randomId + "." + file.getOriginalFilename());
            try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(userFile))) {
               userFile.createNewFile();
               byte[] bytes = file.getBytes();
               stream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("file " + file.getOriginalFilename() + " saved");
            return new ResponseEntity("file saved", HttpStatus.OK);
        }
        else {
            log.info("file is exists or is empty");
            return new ResponseEntity("file didnt saved",HttpStatus.OK);
        }
    }
}
