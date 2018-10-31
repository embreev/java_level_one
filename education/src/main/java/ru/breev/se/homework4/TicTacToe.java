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
        final char[][] array = game.fillArray(fieldSize, EMPTY_CELL);
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
            if (!game.goComputer(array, fieldSize, winLine) && !game.isFinalStep(array, fieldSize, winLine))
                goRandomComputer(array, fieldSize, winLine);
            game.drawField(array);
            if (game.checkWin(array, COMPUTER_CELL, winLine)) {
                System.out.printf("Computer WIN!\n");
                break;
            }
        }
    }

    private boolean checkWin(char[][] array, char block, int winLine) {
        //Diagonal
        int diagonalCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if ((x == y) && (array[x][y] == block)) diagonalCounter += 1;
            }
        }
        if (diagonalCounter != winLine) diagonalCounter = 0;
        //Reverse diagonal
        int diagonalReversCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = (array.length - 1); y >= 0; y--) {
                if (x == (array.length - y - 1) && (array[x][y] == block)) diagonalReversCounter += 1;
            }
        }
        if (diagonalReversCounter != winLine) diagonalReversCounter = 0;
        //Row and Column
        int rowCounter = 0;
        int columnCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] == block) rowCounter += 1;
                if (array[y][x] == block) columnCounter += 1;
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

    private boolean goComputer(char[][] array, int fieldSize, int winLine) {
        //Diagonal
        int diagonalCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if ((x == y) && (array[x][y] == USER_CELL)) diagonalCounter += 1;
            }
        }
        if (winLine - diagonalCounter == 1) {
            for (int x = 0; x < array.length; x++) {
                for (int y = 0; y < array.length; y++) {
                    if ((x == y) && (array[x][y] == EMPTY_CELL)) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
        }
        //Reverse diagonal
        int diagonalReversCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = (array.length - 1); y >= 0; y--) {
                if (x == (array.length - y - 1) && (array[x][y] == USER_CELL)) diagonalReversCounter += 1;
            }
        }
        if ((winLine - diagonalReversCounter) == 1) {
            for (int x = 0; x < array.length; x++) {
                for (int y = (array.length - 1); y >= 0; y--) {
                    if (x == (array.length - y - 1) && (array[x][y] == EMPTY_CELL)) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
        }
        //Row
        int rowCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] == USER_CELL) rowCounter += 1;
            }
            if ((winLine - rowCounter) == 1) {
                for (int y = 0; y < array.length; y++) {
                    if (array[x][y] == EMPTY_CELL) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
            rowCounter = 0;
        }
        //Column
        int columnCounter = 0;
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                if (array[x][y] == USER_CELL) columnCounter += 1;
            }
            if ((winLine - columnCounter) == 1) {
                for (int x = 0; x < array.length; x++) {
                    if (array[x][y] == EMPTY_CELL) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
            columnCounter = 0;
        }
        return false;
    }

    private boolean isFinalStep(char[][] array, int fieldSize, int winLine) {
        //Diagonal
        int diagonalCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if ((x == y) && (array[x][y] == COMPUTER_CELL)) diagonalCounter += 1;
            }
        }
        if (winLine - diagonalCounter == 1) {
            for (int x = 0; x < array.length; x++) {
                for (int y = 0; y < array.length; y++) {
                    if ((x == y) && (array[x][y] == EMPTY_CELL)) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
        }
        //Reverse diagonal
        int diagonalReversCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = (array.length - 1); y >= 0; y--) {
                if (x == (array.length - y - 1) && (array[x][y] == COMPUTER_CELL)) diagonalReversCounter += 1;
            }
        }
        if ((winLine - diagonalReversCounter) == 1) {
            for (int x = 0; x < array.length; x++) {
                for (int y = (array.length - 1); y >= 0; y--) {
                    if (x == (array.length - y - 1) && (array[x][y] == EMPTY_CELL)) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
        }
        //Row
        int rowCounter = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] == COMPUTER_CELL) rowCounter += 1;
            }
            if ((winLine - rowCounter) == 1) {
                for (int y = 0; y < array.length; y++) {
                    if (array[x][y] == EMPTY_CELL) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
            break;
        }
        //Column
        int columnCounter = 0;
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                if (array[x][y] == COMPUTER_CELL) columnCounter += 1;
            }
            if ((winLine - columnCounter) == 1) {
                for (int x = 0; x < array.length; x++) {
                    if (array[x][y] == EMPTY_CELL) {
                        array[x][y] = COMPUTER_CELL;
                        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
                        return true;
                    }
                }
            }
            break;
        }
        return false;
    }

    //    Random move computer
    private void goRandomComputer(char[][] array, int fieldSize, int winLine) {
        int x;
        int y;
        final Random random = new Random();
        do {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        } while (game.checkCell(array, x, y, fieldSize));
        array[x][y] = COMPUTER_CELL;
        System.out.printf("Computer x=%s, y=%s\n", x + 1, y + 1);
    }

    private boolean checkCell(char[][] array, int x, int y, int fieldSize) {
        boolean result = (x < 0 || x >= fieldSize || y < 0 || y >= fieldSize ||
                array[x][y] != EMPTY_CELL) ? true : false;
//        if (result) System.out.printf("Incorrect coordinate...\n");
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