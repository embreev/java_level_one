package ru.breev.se.homework6;

public abstract class Animal {

    public String color;
    public String name;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void run(float distance);
    abstract void swim(float distance);
    abstract void jump(float distance);
}