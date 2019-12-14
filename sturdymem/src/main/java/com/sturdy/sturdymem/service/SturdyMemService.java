package com.sturdy.sturdymem.service;

import com.sturdy.sturdymem.entity.MyTransactionResource;
import org.bson.types.ObjectId;

public interface SturdyMemService {


    boolean saveMyTransaction(MyTransactionResource myTransactionResource);
    //MyTransactionResource fetchMyTransaction(String transId);
    boolean updateMyTransaction(String transId, MyTransactionResource myTransactionResource);

    //Recent additions
    public MyTransactionResource fetchTransactionByTransId(String transId);
    public MyTransactionResource fetchTransactionById(ObjectId id);

}
