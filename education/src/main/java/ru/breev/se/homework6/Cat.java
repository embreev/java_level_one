package ru.breev.se.homework6;

class Cat extends Animal {

    public Cat(String color, String name) {
        super(color, name);
        maxDistanceRun = (float) (200 * Math.random());
        maxDistanceJump = (float) (2 * Math.random());
        System.out.printf("maxDistanceRun = %f; ", maxDistanceRun);
        System.out.printf("maxDistanceJump = %f.\n", maxDistanceJump);
    }

    @Override
    void run(float distance) {
        final boolean result = distance <= maxDistanceRun;
        System.out.printf("Can a cat run %f? - %b\n", distance, result);
    }

    @Override
    void swim(float distance) {
        System.out.printf("Cat can not swim\n");
    }

    @Override
    void jump(float distance) {
        final boolean result = distance <= maxDistanceJump;
        System.out.printf("Can a cat jump %f? - %b\n", distance, result);
    }
}
