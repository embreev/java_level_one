package ru.breev.se.homework6;

public abstract class Animal {

    private String color;
    private String name;
    static float maxDistanceRun;
    static float maxDistanceSwim;
    static float maxDistanceJump;

    Animal(String color, String name) {
        this.color = color;
        this.name = name;
    }

    String getColor() {
        return color;
    }

    protected String getName() {
        return name;
    }

    abstract void run(float distance);
    abstract void swim(float distance);
    abstract void jump(float distance);
}