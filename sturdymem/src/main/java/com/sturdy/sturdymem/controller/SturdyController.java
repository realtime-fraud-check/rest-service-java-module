package com.sturdy.sturdymem.controller;


import com.sturdy.sturdymem.service.SturdyMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SturdyController {

    @Autowired
    SturdyMemService sturdyMemService;

    @GetMapping ("/api/v1")
    public String getUser() {
        return "OK";

    }
    @PostMapping("/api/v1")
    public String uploadFile(@RequestParam("file")
                                         MultipartFile file) {
        System.out.println("File Received"); //TODO - replace with logger
        sturdyMemService.saveToDictionary(file);
        return "OK";

    }


}
