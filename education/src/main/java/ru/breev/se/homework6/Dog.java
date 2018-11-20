package ru.breev.se.homework6;

class Dog extends Animal {

    public Dog(String color, String name) {
        super(color, name);
        maxDistanceRun = (float) (500 * Math.random());
        maxDistanceSwim = (float) (10 * Math.random());
        maxDistanceJump  = (float) (0.5 * Math.random());
        System.out.printf("maxDistanceRun = %f; ", maxDistanceRun);
        System.out.printf("maxDistanceSwim = %f; ", maxDistanceSwim);
        System.out.printf("maxDistanceJump = %f.\n", maxDistanceJump);
    }

    @Override
    void run(float distance) {
        final boolean result = distance <= maxDistanceRun;
        System.out.printf("Can a dog run %f? - %b\n", distance, result);
    }

    @Override
    void swim(float distance) {
        final boolean result = distance <= maxDistanceSwim;
        System.out.printf("Can a dog swim %f? - %b\n", distance, result);
    }

    @Override
    void jump(float distance) {
        final boolean result = distance <= maxDistanceJump;
        System.out.printf("Can a dog jump %f? - %b\n", distance, result);
    }
}
