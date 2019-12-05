package com.sturdy.sturdymem.dao;

import com.sturdy.sturdymem.entity.MyResource;
import com.sturdy.sturdymem.entity.MyTransactionResource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyTransactionRepository extends MongoRepository<MyTransactionResource, String> {
}