package com.sturdy.sturdymem.controller;


import com.sturdy.sturdymem.entity.MyTransactionResource;
import com.sturdy.sturdymem.service.SturdyMemService;
import org.apache.catalina.connector.Response;
import org.bson.types.ObjectId;
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


    //TODO revisit the commented out codes. @Sid-Dec14 - Also removed this commented part,except createTransaction() . Assuming the todo is done . @Vinod:pls confirm

    @PostMapping("/transactions/")
    public boolean createTransaction(@RequestBody MyTransactionResource myTransactionResource) {
        return sturdyMemService.saveMyTransaction(myTransactionResource);
    }


    @PutMapping("/transactions/{transId}")
    public boolean updateTransaction(@PathParam("transId") String transId, MyTransactionResource myTransactionResource) {
        return sturdyMemService.updateMyTransaction(transId,myTransactionResource);
    }


    @GetMapping("/transactions/{trans-id}")
    public MyTransactionResource fetchTransactionByTransId(@PathParam("transId") String transId) {
        return sturdyMemService.fetchTransactionByTransId(transId);
    }

    @GetMapping("/transactions/{id}")
    public MyTransactionResource fetchTransactionById(@PathParam("id") String id){
        //Creating #ObjectId from provided string
        return sturdyMemService.fetchTransactionById(new ObjectId(id));
    }
}
