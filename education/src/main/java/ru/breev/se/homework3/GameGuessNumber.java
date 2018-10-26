package ru.breev.se.homework3;

import java.util.Scanner;

public class GameGuessNumber {

    public static int guessNumber() {
        int numberPC = (int) (Math.random() * 10);
        return numberPC;
    }

    private static String checkNumber(int userNumber, int computerNumber){
        String result = "";
        if (userNumber < computerNumber) result = "User more Computer";
        if (userNumber > computerNumber) result = "User less Computer";
        if (userNumber == computerNumber) result = "User WIN!";
        return result;
    }

    public static void main(String[] args) {
        GameGuessNumber game = new GameGuessNumber();
        System.out.printf("NumberPC = %s", game.guessNumber());
        Scanner sc = new Scanner(System.in);
    }

}
