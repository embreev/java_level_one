package ru.breev.se.homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        boolean next = true;
        System.out.println("Enter appetite cat:");

        final List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik"));
        cats.add(new Cat("Mursik"));
        cats.add(new Cat("Vasiliska"));
        cats.add(new Cat("Lila"));
        cats.add(new Cat("Vasily"));

        final Plate plate = new Plate(random.nextInt(100));

        while (next) {
            System.out.println("plate: " + plate.getFood());
            System.out.println();

            for (int i = 0; i < cats.size(); i++) {
                cats.get(i).eat(plate);
                System.out.println(cats.get(i).getName() + " " + cats.get(i).isSatiety());
                plate.info();
            }

            System.out.println("Add food, yes/no ?");
            final String answer = scanner.nextLine();
            if ("yes".equals(answer.toLowerCase())) {
                plate.addFood();
            } else next = false;

        }

    }
}

