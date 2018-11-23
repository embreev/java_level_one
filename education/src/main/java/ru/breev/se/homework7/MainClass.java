package ru.breev.se.homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        System.out.println("Enter appetite cat:");

        final List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik"));
        cats.add(new Cat("Mursik"));
//        cats.add(new Cat("Vasiliska"));
//        cats.add(new Cat("Lila"));
//        cats.add(new Cat("Vasily"));

        final Plate plate = new Plate(random.nextInt(100));
        System.out.println("plate: " + plate.getFood());
        System.out.println();

        for (int i = 0; i < cats.size(); i++) {
            cats.get(i).eat(plate);
            System.out.println(cats.get(i).getName() + " " + cats.get(i).isSatiety());
            plate.info();
        }

    }
}

