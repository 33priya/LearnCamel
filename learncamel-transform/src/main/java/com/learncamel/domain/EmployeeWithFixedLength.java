package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.math.BigDecimal;
import java.time.LocalDate;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

    @DataField(pos = 1, length = 3)
    private int id;
    @DataField(pos = 2, length = 10, trim = true, align = "L")
    private String name;
    @DataField(pos = 3, length = 8)
    private String role;
    @DataField(pos = 4, length = 9, pattern = "ddMMMyyyy")
    private LocalDate joiningDate;
    @DataField(pos = 5, delimiter = "^")
    private int age;
    @DataField(pos = 6, length = 6, precision = 2)
    private BigDecimal salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", joiningDate=" + joiningDate +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
