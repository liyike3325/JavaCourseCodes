package com.bootcamp.spring02.bean02;

import org.springframework.beans.factory.annotation.Autowired;

public class Boss {

    @Autowired
    private Car car;

    @Autowired
    private Office office;

    @Override
    public String toString() {
        return "car:" + car + "\n" + "office:" + office;
    }
}
