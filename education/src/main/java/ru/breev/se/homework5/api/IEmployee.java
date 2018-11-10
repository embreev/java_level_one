package ru.breev.se.homework5.api;

public interface IEmployee {
    void setPosition(String position);

    String getPosition();

    void setSalary(int salary);

    int getSalary();

    int getQuantityEmployees();

    void addEmployee(String name, String position, String email, String phone, int salary, int age);

    void getInfoByID(int id);

    void getInfoByName(String fullName);
}
