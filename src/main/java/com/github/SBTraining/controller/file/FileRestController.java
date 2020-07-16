package com.github.SBTraining.controller.file;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;


@RestController
public class FileRestController {

    static Logger log = Logger.getLogger(FileRestController.class.getName());

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(file!=null) {
            File wayFile = new File("C:\\Games-2\\SBTraning\\src\\main\\resources\\files\\file.txt");
            wayFile.createNewFile();
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(wayFile));
            stream.write(bytes);
            log.info("file saved");
            stream.close();
        }
        return "file saved";
    }
}
