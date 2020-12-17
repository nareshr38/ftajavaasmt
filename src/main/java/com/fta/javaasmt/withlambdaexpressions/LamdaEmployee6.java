package com.fta.javaasmt.withlambdaexpressions;

public class LamdaEmployee6 implements Comparable<LamdaEmployee6> {
    private int empAge;
    private String empName;
    private int empID;

    public int getEmpAge() {
        return empAge;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpID() {
        return empID;
    }


    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }


    public LamdaEmployee6(int empAge, String empName, int empID) {
        this.empAge = empAge;
        this.empName = empName;
        this.empID = empID;
    }

    @Override
    public String toString() {

        return "Name:" + empName;
    }

    @Override
    public int compareTo(LamdaEmployee6 o) {
        return o.empID;
    }


}
