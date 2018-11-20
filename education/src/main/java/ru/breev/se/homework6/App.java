package ru.breev.se.homework6;

public class App {

    public static void main(String[] args) {
        System.out.println("Class Dog");
        Dog dog = new Dog("black", "Rex");
        dog.run(100);
        dog.swim(150);
        dog.jump(5);
        System.out.println(dog.getName());
        System.out.println(dog.getColor());

        System.out.println();

        System.out.println("Class Cat");
        Cat cat = new Cat("white", "Lila");
        cat.run(200);
        cat.swim(100);
        cat.jump(2);
        System.out.println(cat.getName());
        System.out.println(cat.getColor());

    }
}
