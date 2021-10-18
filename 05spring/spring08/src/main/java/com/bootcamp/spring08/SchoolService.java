package com.bootcamp.spring08;

import lombok.Data;

@Data
public class SchoolService implements ISchool {

    Klass class1;

    Student student100;

    public SchoolService(Klass class1, Student student100) {
        this.class1 = class1;
        this.student100 = student100;
    }

    @Override
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
