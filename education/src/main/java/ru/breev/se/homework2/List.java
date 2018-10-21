package ru.breev.se.homework2;

public class List {
    public static void main(String[] args) {
        int[] array = new int[50];
        int min = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        for (int element : array) {
            if (element > max) max = element;
            if (element < min) min = element;
            System.out.printf("%s ", element);
        }
        System.out.printf("\nMin = %s, Max = %s", min, max);
    }
}