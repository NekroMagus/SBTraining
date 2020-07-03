package com.github.SBTraining.controller.file;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileRestController {

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File wayFile = new File("C:\\Games-2\\SBTraning\\src\\main\\resources\\files\\file.txt");
        wayFile.createNewFile();
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(wayFile));
        stream.write(bytes);
        stream.close();
    }
}
