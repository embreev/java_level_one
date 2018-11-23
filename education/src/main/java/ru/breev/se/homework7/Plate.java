package ru.breev.se.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if ( n <= food) food -= n;
        else System.out.println("not enough food in plate");
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood (int n) {
        food += n;
    }
}
