package com.sturdy.sturdymem.dao;

import com.sturdy.sturdymem.entity.MyResource;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * MongoRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
 * Most of the regularly used queries like getByID(), findAll, save() comes from CrudRepository
 * Added methods to find transactions using name.
 * */

@Repository
public interface MyRepository extends MongoRepository<MyResource, ObjectId> {

    /**
     * No need implementation, just one interface, and you have CRUD, thanks Spring Data
     * Method naming convention : getByName => getBy + field by which we need to select.
     * We are selecting the mongo document based on the field 'Name' and hence the menthod is named getByName.
     * Mapping of object # MyResource fields with the Mongo document is done by default.
     */

    public MyResource getByName(String name);

    //TODO Add more feilds in our entities and methods in our repository

}