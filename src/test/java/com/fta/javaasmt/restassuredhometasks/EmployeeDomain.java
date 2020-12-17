package com.fta.javaasmt.restassuredhometasks;

public class EmployeeDomain {

    private int id;
    private String employee_name;
    private int employee_age;
    private int empoyee_salary;





    public EmployeeDomain(int id,String employee_name,int employee_age,int empoyee_salary)
    {
        this.id=id;
        this.employee_name=employee_name;
        this.employee_age = employee_age;
    }

    public int getEmpoyee_salary() {
        return empoyee_salary;
    }

    public void setEmpoyee_salary(int empoyee_salary) {
        this.empoyee_salary = empoyee_salary;
    }
    public EmployeeDomain(int id)
    {
        this.id=id;

    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }




    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
