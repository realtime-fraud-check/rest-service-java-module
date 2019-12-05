package com.sturdy.sturdymem.controller;


import com.sturdy.sturdymem.entity.MyTransactionResource;
import com.sturdy.sturdymem.service.SturdyMemService;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@RequestMapping("/api/v1")
@RestController
public class SturdyController {
    private Logger logger = LoggerFactory.getLogger(SturdyController.class);

    @Autowired
    private SturdyMemService sturdyMemService;

    @GetMapping("/words")
    public boolean getUser(@RequestParam String targetString) {
        return sturdyMemService.findIfTargetWordExists(targetString);
    }

    @PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("file")
                                     MultipartFile file) {
        if(null == file) {
            new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        logger.info("File Received .file name {} . file size {}", file.getOriginalFilename(),file.getSize());
        sturdyMemService.saveToDictionary(file);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @PostMapping("/transactions/")
    public boolean createTransaction(MyTransactionResource myTransactionResource) {
        return sturdyMemService.saveMyTransaction(myTransactionResource);
    }


    @PutMapping("/transactions/{transId}")
    public boolean updateTransaction(@PathParam("transId") String transId, MyTransactionResource myTransactionResource) {
        return sturdyMemService.updateMyTransaction(transId,myTransactionResource);
    }


    @GetMapping("/transactions/{trans-id}")
    public MyTransactionResource fetchTransaction(@PathParam("transId") String transId) {
        return sturdyMemService.fetchMyTransaction(transId);
    }
}
