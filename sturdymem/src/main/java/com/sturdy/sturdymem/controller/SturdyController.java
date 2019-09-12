package com.sturdy.sturdymem.controller;


import com.sturdy.sturdymem.service.SturdyMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/v1")
@RestController
public class SturdyController {

    @Autowired
    private SturdyMemService sturdyMemService;

    @GetMapping("/words")
    public boolean getUser(@RequestParam String targetString) {

        return sturdyMemService.findIfTargetWordExists(targetString);

    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")
                                     MultipartFile file) {
        System.out.println("File Received"); //TODO - replace with logger
        sturdyMemService.saveToDictionary(file);
        return "OK";

    }


}
