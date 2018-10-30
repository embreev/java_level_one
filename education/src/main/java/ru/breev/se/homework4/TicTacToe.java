package ru.breev.se.homework4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TicTacToe game = new TicTacToe();
    private static final char USER_CELL = 'X';
    private static final char COMPUTER_CELL = 'O';
    private static final char EMPTY_CELL = '.';

    public static void main(String[] args) {
        game.runGame();
    }

    private void runGame() {
        System.out.printf("Run the Game\n");
        System.out.printf("Enter Field size:\n");
        final int fieldSize = scanner.nextInt();
        int winLine;
        do {
            System.out.printf("Enter the number of winning cells:\n");
            winLine = scanner.nextInt();
        } while (fieldSize < winLine);
        char[][] array = game.fillArray(fieldSize, EMPTY_CELL);
        game.drawField(array);
        while (true) {
            game.checkEmpty(array);
            game.goPlayer(array, fieldSize);
            game.drawField(array);
            if (game.checkWin(array, USER_CELL, winLine)) {
                System.out.printf("User WIN!\n");
                break;
            }
            game.checkEmpty(array);
            game.goComputer(array, fieldSize);
            game.drawField(array);
            if (game.checkWin(array, COMPUTER_CELL, winLine)) {
                System.out.printf("Computer WIN!\n");
                break;
            }
        }
    }

    private boolean checkWin(char[][] array, char block, int winLine) {
        int diagonalCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if ((x == y) && (array[x][y] == block)) diagonalCounter += 1;
            }
        }
        if (diagonalCounter != winLine) diagonalCounter = 0;
        int diagonalReversCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = (array.length - 1); y >= 0; y--) {
                if (x == (array.length - y - 1) && (array[x][y] == block)) diagonalReversCounter += 1;
            }
        }
        if (diagonalReversCounter != winLine) diagonalReversCounter = 0;
        int rowCounter = 0;
        int columnCounter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == block) rowCounter += 1;
                if (array[j][i] == block) columnCounter += 1;
            }
            if (rowCounter != winLine) rowCounter = 0;
            else break;
            if (columnCounter != winLine) columnCounter = 0;
            else break;
        }
        return (diagonalCounter == winLine || diagonalReversCounter == winLine
                || rowCounter == winLine || columnCounter == winLine) ? true : false;
    }

    private void checkEmpty(char[][] array) {
        boolean result = false;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] == EMPTY_CELL) result = true;
            }
        }
        if (!result) {
            System.out.printf("There is no winner in the game!");
            System.exit(0);
        }
    }

    private void goPlayer(char[][] array, int fieldSize) {
        int x;
        int y;
        do {
            System.out.printf("Enter coordinate - x:\n");
            x = scanner.nextInt() - 1;
            System.out.printf("Enter coordinate - y:\n");
            y = scanner.nextInt() - 1;
        }
        while (game.checkCell(array, x, y, fieldSize));
        array[x][y] = USER_CELL;
    }

    private void goComputer(char[][] array, int fieldSize) {
        int x;
        int y;
        do {
            x = new Random().nextInt(fieldSize);
            y = new Random().nextInt(fieldSize);
        } while (game.checkCell(array, x, y, fieldSize));
        array[x][y] = COMPUTER_CELL;
        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
    }

    private boolean checkCell(char[][] array, int x, int y, int fieldSize) {
        boolean result = (x < 0 || x >= fieldSize || y < 0 || y >= fieldSize ||
                array[x][y] != EMPTY_CELL) ? true : false;
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

    private char[][] fillArray(int fieldSize, char block) {
        final char[][] array = new char[fieldSize][fieldSize];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                array[x][y] = block;
            }
        }
        return array;
    }
}


