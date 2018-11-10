package ru.breev.se.homework5.human;

import ru.breev.se.homework5.api.IEmployee;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements IEmployee {

    private String position;
    private int salary;
    final public static List<Employee> arrayEmployee = new ArrayList<>();

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getQuantityEmployees() {
        return arrayEmployee.size();
    }

    @Override
    public void addEmployee(String name, String position, String email, String phone, int salary, int age) {
        final Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setPosition(position);
        employee.setSalary(salary);
        arrayEmployee.add(employee);
    }

    @Override
    public void getInfoByID(int id) {
        final Employee employee = arrayEmployee.get(id);
        System.out.printf("Имя: %s; Должность: %s; E-Mail: %s; Телефон: %s; Зарплата: %s; Возраст: %s.\n",
                employee.getName(), employee.getPosition(), employee.getEmail(),
                employee.getPhone(), employee.getSalary(), employee.getAge());
    }

    @Override
    public void getInfoByName(String name) {
        boolean checkName = false;
        for (int i = 0; i < arrayEmployee.size(); i++) {
            final Employee employee = arrayEmployee.get(i);
            if (employee.getName().equals(name)) {
                System.out.printf("Имя: %s; Должность: %s; E-Mail: %s; Телефон: %s; Зарплата: %s; Возраст: %s.\n",
                        employee.getName(), employee.getPosition(), employee.getEmail(),
                        employee.getPhone(), employee.getSalary(), employee.getAge());
                checkName = true;
            }
        }
        if (!checkName) System.out.printf("Сотрудника с именем %s не существует!\n", name);
    }

}