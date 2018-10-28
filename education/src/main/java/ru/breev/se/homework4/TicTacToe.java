package ru.breev.se.homework4;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        final char userBlock = 'X';
        final char computerBlock = 'O';
        final char emptyBlock = '.';
        final TicTacToe game = new TicTacToe();
        System.out.printf("Run the Game\n");
        final Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter file size:\n");
        final int fieldSize = scanner.nextInt();
        System.out.printf("Enter the number of winning blocks:\n");
        final int winBlock = scanner.nextInt();
        final char[][] array = game.fillArray(fieldSize);
        game.drawField(array);
    }

    private void drawField(char[][] array) {
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                System.out.printf("%s ", array[x][y]);
            }
            System.out.print("\n");
        }
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
}


