package ru.breev.se.homework7;

import java.util.Scanner;

public class Plate {
    private int food;
    private final Scanner scanner = new Scanner(System.in);

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (n <= food) food -= n;
        else System.out.println("not enough food in plate");
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood () {
        System.out.println("Enter quantity eat: ");
        final int quantityEat = scanner.nextInt();
        food += quantityEat;
    }
}
