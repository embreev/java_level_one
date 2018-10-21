package ru.breev.se.homework2;

public class Array {
    static final byte[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) (arr[i] == 1 ? 0 : 1);
        }
        for (byte element : arr) {
            System.out.printf("%s ", element);
        }
    }
}
