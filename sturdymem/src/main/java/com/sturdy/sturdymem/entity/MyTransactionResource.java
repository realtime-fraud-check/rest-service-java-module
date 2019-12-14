package com.sturdy.sturdymem.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


//@QueryEntity
@Document(collection = "my_transaction")
public class MyTransactionResource {

    @Id
    private ObjectId id;
    private  String transId;
    private  String transDetails ;

    //Added Getters and setters.

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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



    public MyTransactionResource(String transId, String transDetails) {
        this.transId = transId;
        this.transDetails = transDetails;
    }



    /** Removing getTransDetails() and setTransDetails(String transDetails)().
     Suggestion: We can use MyTransactionResource as a entity mapping to actual table(or Collection in this case).
     We can handle getting multiple values in our service class.
     */

    /*public String getTransDetails() {
        return transDetails;
    }

    public void setTransDetails(String transDetails) setTransDetails(String transDetails){
        this.transDetails = transDetails;
    } */
}
