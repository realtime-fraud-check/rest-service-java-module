package com.sturdy.sturdymem.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.ConstructorProperties;
import java.util.List;


//@QueryEntity
@Document(collection = "my_transaction")
//TODO - Improve the formatting of this class -after we conclude on the un-used code .
//@ConstructorProperties("")
public class MyTransactionResource {

    @Id
    private ObjectId id;
    private  String transId;
    private  String transDetails ;

    // Dec 12 - new tentative fields- just for mongo db - populating
    private  String customerFirstName;
    private  String customerLastName ;
    private String transactionAmount ;
    private String transactionCountry ;


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

    //default
    public MyTransactionResource() {
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



    //Getter Setter for new tentatives

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        customerLastName = customerLastName;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionCountry() {
        return transactionCountry;
    }

    public void setTransactionCountry(String transactionCountry) {
        this.transactionCountry = transactionCountry;
    }
}
