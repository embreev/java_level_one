package ru.breev.se.homework52;

import java.util.Scanner;

public class Person {
    final String name;
    final String position;
    final String email;
    final String phone;
    final int salary;
    final int age;
    final static Person[] persArray = new Person[5];
    final static Scanner scanner = new Scanner(System.in);

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public static void getInfoByAge(int age) {
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > age)
                System.out.printf("Имя: %s; Должность: %s; E-Mail: %s; Телефон: %s; Зарплата: %s; Возраст: %s.\n",
                        persArray[i].name, persArray[i].position, persArray[i].email,
                        persArray[i].phone, persArray[i].salary, persArray[i].age);
        }
    }

    public static void main(String[] args) {
        persArray[0] = new Person("Ivan", "Developer", "ivan@it.org", "111111", 150000, 41);
        persArray[1] = new Person("Fedot", "Developer", "fedot@it.org", "222222", 140000, 45);
        persArray[2] = new Person("Alex", "QA Engineer", "alex@it.org", "333333", 100000, 38);
        persArray[3] = new Person("Dima", "Developer", "dima@it.org", "444444", 145000, 37);
        persArray[4] = new Person("Seva", "DevOps Engineer", "seva@it.org", "555555", 120000, 42);

        System.out.printf("Введите возраст сотрудников, старше которого нужно вывести:\n");
        final int age = scanner.nextInt();
        getInfoByAge(age);
    }
}
