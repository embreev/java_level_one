package ru.breev.se.homework5;

import ru.breev.se.homework5.api.IEmployee;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Human implements IEmployee {

    private String position;
    private int salary;
    private static List<Employee> arrayEmployee = new ArrayList<>();

    @Override
    public void addEmployee() {
//        arrayEmployee.add(new Employee("Петя", "Тракториск",
//                "petya@mail.ru", "123456789", 10000, 32));
//        arrayEmployee.add(new Employee("Вася", "Комбайнер",
//                "vasya@mail.ru", "123123123", 11000, 53));
//        arrayEmployee.add(new Employee("Иван", "Механизатор",
//                "ivan@mail.ru", "456456456", 8000, 41));
    };

    @Override
    public void getInfoByID(int id) {
        System.out.printf("Имя: %s, Должность: %s, E-Mail: %s, Телефон: %s, " +
                        "Зарплата: %s, Возраст: %s, \n");
    }

    @Override
    public void getInfoByName(String name) {
        for (int i = 0; i < arrayEmployee.size(); i++) {
            System.out.printf("Имя: %s, Должность: %s, E-Mail: %s, Телефон: %s, " +
                            "Зарплата: %s, Возраст: %s, \n");
        }
    }

}
