package ru.breev.se.homework7;

import java.util.Random;

public class Cat {
    final Random random = new Random();
    private final String name;
    private int appetite = random.nextInt(50);;
    private static boolean satiety = false;

    public Cat(String name) {
        this.name = name;
        System.out.println(name + ": " + appetite);
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate p) {
        satiety = p.getFood() - appetite >= 0 ? true : false;
        if (isSatiety()) {
            p.decreaseFood(appetite);
            appetite = 0;
        }
        else System.out.println("not enough food for cat");
    }
}
