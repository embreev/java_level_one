package ru.breev.se.homework2;

import java.util.Scanner;

public class ListExample {
    public static void main(String[] args) {
        //5
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array dimension:");
        final int dimension = scanner.nextInt();
        ListExample list = new ListExample();
        int[] newList = list.fillArray(dimension);
        for (int element : newList) System.out.printf("%s ", element);
        System.out.printf("\nMin = %s, Max = %s", list.getMin(newList), list.getMax(newList));
        //6
        //check array
        //int[] arrayTest = {1, 2, 3};
        System.out.printf("\nArray is balanced? - %s", list.checkBalance(newList));
        //7
        System.out.printf("\n\nEnter shift element:\n");
        final int shift = scanner.nextInt();
        newList = list.shiftElementArray(newList, shift);
        for (int element : newList) System.out.printf("%s ", element);
    }

    public int[] fillArray(int dimension) {
        int[] array = new int[dimension];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public int getMin(int[] array) {
        //что-то фантазии не хватило )
        int min = 2147483647;
        for (int element : array) {
            if (element < min) min = element;
        }
        return min;
    }

    public int getMax(int[] array) {
        //что-то фантазии не хватило )
        int max = -2147483648;
        for (int element : array) {
            if (element > max) max = element;
        }
        return max;
    }

    public boolean checkBalance(int[] array) {
        int a = 0;
        int b;
        boolean result = false;
        for (int i = 0; i < array.length - 1; i++) {
            a += array[i];
            b = 0;
            int step = i + 1;
            for (int j = step; j < array.length; j++) {
                b += array[j];
            }
            result = (a == b) ? true : false;
            if (result) break;
        }
        return result;
    }

    public int[] shiftElementArray(int[] array, int s) {
        for (int i = 0; i < array.length; i++) {
            array[i] += s;
        }
        return array;
    }
}