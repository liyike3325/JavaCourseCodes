package com.bootcamp.spring02.bean02;

public class Office {

    private String officeNo = "001";

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    @Override
    public String toString() {
        return "officeNo:" + officeNo;
    }
}
