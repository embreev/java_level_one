package ru.breev.se.homework6;

public class Dog extends Animal {

    final static float MAX_DISTANCE_RUN = 500;
    final static float MAX_DISTANCE_SWIM = 0.5F;
    final static float MAX_DISTANCE_JUMP = 10;

    public Dog(String color, String name) {
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
        final boolean result = distance <= MAX_DISTANCE_SWIM;
        System.out.println(result);
    }

    @Override
    void jump(float distance) {
        final boolean result = distance <= MAX_DISTANCE_JUMP;
        System.out.println(result);
    }
}
