package com.sturdy.sturdymem.entity;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


//@QueryEntity
@Document
public class MyResource {

    private  String name;

    @TextIndexed
    private List<String> values;

    public MyResource(String name, List<String> values) {
        this.name = name;
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
