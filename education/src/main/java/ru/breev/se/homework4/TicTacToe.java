package ru.breev.se.homework4;

import java.util.Scanner;

public class TicTacToe {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TicTacToe game = new TicTacToe();

    public static void main(String[] args) {
        System.out.printf("Run the Game\n");
        System.out.printf("Enter Field size:\n");
//        System.out.printf("Enter the number of winning blocks:\n");
//        final int winBlock = scanner.nextInt();
        final int fieldSize = scanner.nextInt();
        char[][] array = game.fillArray(fieldSize);
        game.drawField(array);
        game.goPlayer(array, fieldSize);
//        array = game.refillArray(array, userX, userY, "user");
        game.drawField(array);
//        game.checkWin(array);
//        game.goPC();
    }

//    private boolean checkWin(char[][] array) {
//        for (int x; x < array.length; x++) {
//            for (int y; y < array.length; y++) {
//                array
//            }
//
//        }
//        return win;
//    }

    private void goPlayer(char[][] array, int fieldSize) {
        int x;
        int y;
        do {
            System.out.printf("Enter coordinate - x:\n");
            x = scanner.nextInt() - 1;
            System.out.printf("Enter coordinate - y:\n");
            y = scanner.nextInt() - 1;
        }
        while (game.checkCell(x, y, fieldSize));
        array[x][y] = 'X';
    }

    private boolean checkCell(int x, int y, int fieldSize) {
        boolean result = (x < 0 || x > fieldSize || y < 0 || y > fieldSize) ? true : false;
        if (result) System.out.printf("Incorrect coordinate...\n");
        return result;
    }

    private void drawField(char[][] array) {
        for (int x = 0; x <= array.length; x++) System.out.printf("%s ", x);
        System.out.printf("\n");
        for (int x = 0; x < array.length; x++) {
            System.out.printf("%s ", x + 1);
            for (int y = 0; y < array.length; y++) {
                System.out.printf("%s ", array[x][y]);
            }
            System.out.print("\n");
        }
        System.out.printf("\n");
    }

    private char[][] fillArray(int fieldSize) {
        final char[][] array = new char[fieldSize][fieldSize];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                array[x][y] = '.';
            }
        }
        return array;
    }

    private char[][] refillArray(char[][] array, int coordinateX, int coordinateY, String whoseTurn) {
        if (whoseTurn.equals("user")) array[coordinateX][coordinateY] = 'X';
        if (whoseTurn.equals("pc")) array[coordinateX][coordinateY] = 'O';
        return array;
    }
}


