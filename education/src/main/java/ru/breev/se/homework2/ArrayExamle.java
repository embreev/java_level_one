package ru.breev.se.homework2;

public class ArrayExamle {
    private static final byte[] arrayBit = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    private static final int[] arrayInt = new int[8];
    private static final int[] arrayNew = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    private static final int[][] arraySquare = new int[10][10];

    public static void main(String[] args) {
        //1
        for (int i = 0; i < arrayBit.length; i++) {
            arrayBit[i] = (byte) (arrayBit[i] == 1 ? 0 : 1);
        }
        for (byte element : arrayBit) {
            System.out.printf("%s ", element);
        }
        //2
        System.out.printf("\n\n");
        for (int i = 0; i < arrayInt.length; i++) {
            if (i == 0) arrayInt[i] = 0;
            else arrayInt[i] = arrayInt[i - 1] + 3;
        }
        for (int element : arrayInt) {
            System.out.printf("%s ", element);
        }
        //3
        System.out.printf("\n\n");
        for (int i = 0; i < arrayNew.length; i++) {
            if (arrayNew[i] < 6) arrayNew[i] *= 2;
        }
        for (int element : arrayNew) {
            System.out.printf("%s ", element);
        }
        //4
        System.out.printf("\n\n");
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0; j < arraySquare.length; j++) {
                if (i == j) arraySquare[i][j] = 1;
                else arraySquare[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0; j < arraySquare.length; j++) {
                System.out.printf("%s ", arraySquare[i][j]);
            }
            System.out.println();
        }
    }
}
