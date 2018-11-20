package ru.breev.se.homework6;

public class Cat extends Animal {

    final static float MAX_DISTANCE_RUN = 200;
    final static float MAX_DISTANCE_JUMP = 2;

    public Cat(String color, String name) {
        super.color = color;
        super.name = name;
    }

    @Override
    void run(float distance) {
        final boolean result = distance <= MAX_DISTANCE_RUN;
        System.out.println(result);
    }

    @Override
    void swim(float distance) {
        System.out.println("null");
    }

    @Override
    void jump(float distance) {
        final boolean result = distance <= MAX_DISTANCE_JUMP;
        System.out.println(result);
    }
}
