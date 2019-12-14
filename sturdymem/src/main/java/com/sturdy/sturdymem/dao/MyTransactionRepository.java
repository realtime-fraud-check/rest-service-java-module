package com.sturdy.sturdymem.dao;

import com.sturdy.sturdymem.entity.MyResource;
import com.sturdy.sturdymem.entity.MyTransactionResource;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyTransactionRepository extends MongoRepository<MyTransactionResource, ObjectId> {

    /**
     * No need implementation, just one interface, and you have CRUD, thanks Spring Data
     * Method naming convention : getByName => getBy + field by which we need to select.
     * We are selecting the mongo document based on the field 'TransID' and hence the menthod is named getByTransId.
     * Mapping of object # MyResource fields with the Mongo document is done by default.
     */

    //Method to pull #MyTransactionResource using transId.
    public MyTransactionResource getByTransId(String transactionId);

    //Method to pull #MyTransactionResource using TransactionDetails.
    public MyTransactionResource getByTransDetails(String transactionId);

}