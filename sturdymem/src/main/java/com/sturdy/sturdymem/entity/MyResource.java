package com.sturdy.sturdymem.entity;

import java.util.List;

public class MyResource {

    private  String name;
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
