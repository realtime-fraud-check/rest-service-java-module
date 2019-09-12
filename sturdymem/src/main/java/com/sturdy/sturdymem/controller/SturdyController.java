package com.sturdy.sturdymem.controller;


import com.sturdy.sturdymem.service.SturdyMemService;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/v1")
@RestController
public class SturdyController {
    Logger logger = LoggerFactory.getLogger(SturdyController.class);
    @Autowired
    private SturdyMemService sturdyMemService;

    @GetMapping("/words")
    public boolean getUser(@RequestParam String targetString) {
        return sturdyMemService.findIfTargetWordExists(targetString);
    }

    @PostMapping("/uploadFile")
    public int uploadFile(@RequestParam("file")
                                     MultipartFile file) {
        logger.info("File Received .file name {}", file.getOriginalFilename());
        sturdyMemService.saveToDictionary(file);
        return Response.SC_CREATED;

    }


}
