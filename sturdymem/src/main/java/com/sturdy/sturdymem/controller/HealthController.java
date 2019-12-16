package com.sturdy.sturdymem.controller;


import com.sturdy.sturdymem.entity.MyTransactionResource;
import com.sturdy.sturdymem.service.SturdyMemService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequestMapping("/api/v1")
@RestController
public class HealthController {
    private Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/health/check")
    public String fetchHealthStatus(@PathParam("transId") String transId) {
        return "Ok"; // todo - conditionalise later
    }

}
