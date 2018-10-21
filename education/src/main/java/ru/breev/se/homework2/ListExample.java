package ru.breev.se.homework2;

import java.util.Scanner;

public class ListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array dimension:");
        int dimension = scanner.nextInt();
        ListExample list = new ListExample();
        int[] newList = list.fillArray(dimension);
        for (int element : newList) System.out.printf("%s ", element);
        System.out.printf("\nMin = %s, Max = %s", list.getMin(newList), list.getMax(newList));
    }

    public int[] fillArray(int dimension) {
        int[] array = new int[dimension];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public int getMin(int[] array) {
        int min = 1000000;
        for (int element : array) {
            if (element < min) min = element;
        }
        return min;
    }

    public int getMax(int[] array) {
        int max = 0;
        for (int element : array) {
            if (element > max) max = element;
        }
        return max;
    }
}