package ru.breev.se.homework2;

public class ArrayExamle {
    private static final byte[] arrBit = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    private static final int[] arrInt = new int[8];
    private static final int[] arrNew = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    private static final int[][] arrSquare = new int[10][10];

    public static void main(String[] args) {
        //1
        for (int i = 0; i < arrBit.length; i++) {
            arrBit[i] = (byte) (arrBit[i] == 1 ? 0 : 1);
        }
        for (byte element : arrBit) {
            System.out.printf("%s ", element);
        }
        //2
        System.out.printf("\n\n");
        for (int i = 0; i < arrInt.length; i++) {
            if (i == 0) arrInt[i] = 0;
            else arrInt[i] = arrInt[i - 1] + 3;
        }
        for (int element : arrInt) {
            System.out.printf("%s ", element);
        }
        //3
        System.out.printf("\n\n");
        for (int i = 0; i < arrNew.length; i++) {
            if (arrNew[i] < 6) arrNew[i] *= 2;
        }
        for (int element : arrNew) {
            System.out.printf("%s ", element);
        }
        //4
        System.out.printf("\n\n");
        for (int i = 0; i < arrSquare.length; i++) {
            for (int j = 0; j < arrSquare.length; j++) {
                if (i == j) arrSquare[i][j] = 1;
                else arrSquare[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < arrSquare.length; i++) {
            for (int j = 0; j < arrSquare.length; j++) {
                System.out.printf("%s ", arrSquare[i][j]);
            }
            System.out.println();
        }
    }
}
