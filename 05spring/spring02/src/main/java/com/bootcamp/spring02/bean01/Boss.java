package com.bootcamp.spring02.bean01;

public class Boss {

    private Car car;

    private Office office;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "car:" + car + "\n" + "office:" + office;
    }
}
