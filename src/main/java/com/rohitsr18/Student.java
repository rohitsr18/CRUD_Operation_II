package com.rohitsr18;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int sRollNo;
    private String sName;
    private int sAge;

    public int getsRollNo() {
        return sRollNo;
    }

    public void setsRollNo(int sRollNo) {
        this.sRollNo = sRollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sRollNo=" + sRollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
