package com.github.SBTraining.controller.file;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.logging.Logger;


@RestController
public class FileRestController {

    static Logger log = Logger.getLogger(FileRestController.class.getName());

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(file!=null) {

        }
        return "file saved";
    }
}
