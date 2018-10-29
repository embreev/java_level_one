package ru.breev.se.homework4;

import java.util.Scanner;

public class TicTacToe {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final char userBlock = 'X';
        final char computerBlock = 'O';
        final char emptyBlock = '.';
        final TicTacToe game = new TicTacToe();
        System.out.printf("Run the Game\n");
        System.out.printf("Enter file size:\n");
        final int fieldSize = scanner.nextInt();
//        System.out.printf("Enter the number of winning blocks:\n");
//        final int winBlock = scanner.nextInt();
        char[][] array = game.fillArray(fieldSize);
        game.drawField(array);
        int userX = game.goPlayer('x', fieldSize);
        int userY = game.goPlayer('y', fieldSize);
        array = game.refillArray(array, userX, userY, "user");
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

    private int goPlayer(char coordinate, int fieldSize) {
        System.out.printf("Enter coordinate - %s:\n", coordinate);
        int userCoordinate = scanner.nextInt();
        if (userCoordinate > fieldSize) {
            System.out.printf("Incorrect coordinate...\n");
            goPlayer(coordinate, fieldSize);
        }
        return userCoordinate - 1;
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


