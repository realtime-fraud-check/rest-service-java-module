package com.sturdy.sturdymem.dao;

import com.sturdy.sturdymem.entity.MyResource;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyRepository extends MongoRepository<MyResource, String> {
}