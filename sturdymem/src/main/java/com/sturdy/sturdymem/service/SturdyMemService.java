package com.sturdy.sturdymem.service;

import com.sturdy.sturdymem.entity.MyTransactionResource;
import org.springframework.web.multipart.MultipartFile;

public interface SturdyMemService {

    void saveToDictionary(MultipartFile file);

    boolean findIfTargetWordExists(String targetWord);

    boolean saveMyTransaction(MyTransactionResource myTransactionResource);
    MyTransactionResource fetchMyTransaction(String transId);
    boolean updateMyTransaction(String transId, MyTransactionResource myTransactionResource);

}
