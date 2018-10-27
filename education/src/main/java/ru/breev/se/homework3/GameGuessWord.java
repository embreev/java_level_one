package ru.breev.se.homework3;

import java.util.Random;
import java.util.Scanner;

public class GameGuessWord {
    public static void main(String[] args) {
        System.out.printf("Run the Game!\n");
        final Scanner sc = new Scanner(System.in);
        GameGuessWord w = new GameGuessWord();
        final String computerWord = w.chooseRandomWord();
        while (true) {
            System.out.printf("Enter word:\n");
            String userWord = sc.nextLine().toLowerCase();
            if (w.compareWord(userWord, computerWord)) {
                System.out.printf("User WIN! Word = %s\n", userWord);
                System.exit(0);
            }
            for (char letter : w.compareLetter(userWord, computerWord)) {
                System.out.printf("%s", letter);
            }
        }
    }

    private String chooseRandomWord() {
        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        final Random r = new Random();
        final String randomWord = words[r.nextInt(words.length)];
        return randomWord;
    }

    private boolean compareWord(String userWord, String computerWord) {
        boolean result = false;
        if (userWord.equals(computerWord)) result = true;
        return result;
    }

    private char[] compareLetter(String userWord, String computerWord) {
        final char[] letterArray = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
        final int dimension = (userWord.length() < computerWord.length()) ? userWord.length() : computerWord.length();
        for (int i = 0; i < dimension; i++) {
            if (userWord.charAt(i) == computerWord.charAt(i)) letterArray[i] = userWord.charAt(i);
        }
        return letterArray;
    }
}