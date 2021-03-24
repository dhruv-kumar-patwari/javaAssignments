package com.zemoso.assignment12;

public class Student {
    int field_id, age, year_of_enrollment;
    double perTillDate;
    String name, engDepartment, gender;

    Student(int field_id, String name, int age, String gender, String engDepartment, int year_of_enrollment, double perTillDate) {
        this.field_id = field_id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.year_of_enrollment = year_of_enrollment;
        this.perTillDate = perTillDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "field_id=" + field_id +
                ", age=" + age +
                ", year_of_enrollment=" + year_of_enrollment +
                ", perTillDate=" + perTillDate +
                ", name='" + name + '\'' +
                ", engDepartment='" + engDepartment + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
