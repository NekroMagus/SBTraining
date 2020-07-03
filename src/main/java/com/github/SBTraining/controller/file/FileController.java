package com.github.SBTraining.controller.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {

    @GetMapping("/upload")
    public String upload() {
        return "uploadFiles";
    }
}
