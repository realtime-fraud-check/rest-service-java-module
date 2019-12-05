package com.sturdy.sturdymem.entity;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


//@QueryEntity
@Document
public class MyTransactionResource {

    private  String transId;

    private  String transDetails ;

    public MyTransactionResource(String transId, String transDetails) {
        this.transId = transId;
        this.transDetails = transDetails;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransDetails() {
        return transDetails;
    }

    public void setTransDetails(String transDetails) {
        this.transDetails = transDetails;
    }
}
