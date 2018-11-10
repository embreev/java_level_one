package ru.breev.se.homework5;

import ru.breev.se.homework5.human.Employee;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Employee man = new Employee();
        man.addEmployee("Иван", "Тракторист", "ivan@mail.ru", "111111111", 10000, 34);
        man.addEmployee("Петр", "Тракторист", "petr@mail.ru", "222222222", 10000, 31);
        man.addEmployee("Федор", "Комбайнер", "fedor@mail.ru", "333333333", 13000, 30);
        man.addEmployee("Василий", "Комбайнер", "vasya@mail.ru", "444444444", 13000, 42);
        man.addEmployee("Степан", "Механизатор", "stepan@mail.ru", "555555555", 15000, 37);

        System.out.println("Все сотрудники:");
        for (int i = 0; i < man.getQuantityEmployees(); i++) {
            man.getInfoByID(i);
        }
        System.out.println();

        final Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер сотрудника:");
        final int id = scanner.nextInt() - 1;
        if (id < 0 || id >= man.getQuantityEmployees()) System.out.println("Неверный номер");
        else man.getInfoByID(id);

        System.out.println("Введите имя сотрудника:");
        final String name = scanner.next();
        man.getInfoByName(name);
    }
}
