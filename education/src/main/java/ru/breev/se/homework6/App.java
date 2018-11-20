package ru.breev.se.homework6;

public class App {

    public static void main(String[] args) {

        System.out.println("Class Dog");
        System.out.println();
        Dog dog1 = new Dog("black", "Rex");
        System.out.printf("Name - %s\n", dog1.getName());
        System.out.printf("Color - %s\n", dog1.getColor());
        dog1.run(100);
        dog1.swim(150);
        dog1.jump(5);

        System.out.println();

        Dog dog2 = new Dog("yellow", "Dick");
        System.out.printf("Name - %s\n", dog2.getName());
        System.out.printf("Color - %s\n", dog2.getColor());
        dog2.run(50);
        dog2.swim(200);
        dog2.jump(50);

        System.out.println();

        System.out.println("Class Cat");
        System.out.println();
        Cat cat1 = new Cat("white", "Lila");
        System.out.printf("Name - %s\n", cat1.getName());
        System.out.printf("Color - %s\n", cat1.getColor());
        cat1.run(200);
        cat1.swim(100);
        cat1.jump(2);

        Cat cat2 = new Cat("white", "Lila");
        System.out.printf("Name - %s\n", cat2.getName());
        System.out.printf("Color - %s\n", cat2.getColor());
        cat2.run(500);
        cat2.swim(50);
        cat2.jump(20);

    }
}
