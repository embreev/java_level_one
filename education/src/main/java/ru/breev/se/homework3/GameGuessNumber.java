package ru.breev.se.homework3;

import java.util.Scanner;

public class GameGuessNumber {

    public static void main(String[] args) {
        boolean answer = true;
        Scanner sc = new Scanner(System.in);
        GameGuessNumber game = new GameGuessNumber();
        String gameOver = "";
        while (answer) {
            System.out.printf("Run the Game!\n");
            int computerNumber = game.guessNumber();
            int attempt = 3;
            while (attempt != 0) {
                System.out.printf("Attempts left = %s\n", attempt);
                System.out.printf("NumberPC = %s\n", computerNumber);
                int userNumber = sc.nextInt();
                System.out.println(game.checkNumber(userNumber, computerNumber));
                if (userNumber == computerNumber) {
                    gameOver = "User WIN!";
                    break;
                } else {
                    gameOver = "Computer WIN!";
                }

                attempt -= 1;
            }
            System.out.printf("%s\n", gameOver);
            System.out.printf("Game again? 1 - yes, 0 - no\n");
            answer = (sc.nextInt() == 1) ? true : false;
        }
    }

    private int guessNumber() {
        int numberPC = (int) (Math.random() * 10);
        return numberPC;
    }

    private String checkNumber(int userNumber, int computerNumber) {
        String result = "";
        if (userNumber < computerNumber) result = "User < Computer";
        if (userNumber > computerNumber) result = "User > Computer";
        if (userNumber == computerNumber) result = "User = Computer";
        return result;
    }

}
