package com.sturdy.sturdymem.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * DB name comes from application.properties {spring.mongodb.database}
 * collection alias in document maps "my_resource" mongo collection to MyResource Class.
 */

@Document(collection = "my_resource")
public class MyResource {

    /**
     * Adding @Id to indicate this is the primary key
     * Default type of _id in mongoDB is ObjectId (from bson).
     * */
    @Id
    private ObjectId id;
    private String name;

    /*Removing values method. Will refactor later*/

    //@TextIndexed
   // private List<String> values;

    public MyResource(String name, ObjectId id) {
        this.name = name;
        this.id = id;
    }

 /** Removing getValues() and SetValues().
 Suggestion: We can use MyResource as a entity mapping to actual table(or Collection in this case).
             We can handle getting multiple values in our service class.
 */
/*
    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }*/

/**
 * Added Setter and Getter for variables.
 * This way we can convert our entity POJO into Json and pass it along response body.
 * */

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
