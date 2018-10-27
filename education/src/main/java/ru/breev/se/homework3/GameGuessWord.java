package ru.breev.se.homework3;

import java.util.Random;
import java.util.Scanner;

public class GameGuessWord {
    public static void main(String[] args) {
        boolean answer = true;
        System.out.printf("Enter word:\n");
        Scanner sc = new Scanner(System.in);
        GameGuessWord w = new GameGuessWord();
        String userWord = sc.nextLine().toLowerCase();
        String computerWord = w.chooseRandomWord();
        if (w.compareWord(userWord, computerWord)) System.out.printf("User WIN!");
        else System.out.printf("User Word = %s, Computer Word = %s\n", userWord, computerWord);
        for (char letter : w.compareLetter(userWord, computerWord)) {
            System.out.printf("%s", letter);
        }
    }

    private static String chooseRandomWord() {
        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        Random r = new Random();
        String randomWord = words[r.nextInt(words.length)];
        return randomWord;
    }

    private static boolean compareWord(String userWord, String computerWord) {
        boolean result = false;
        if (userWord.equals(computerWord)) result = true;
        return result;
    }

    private char[] compareLetter(String userWord, String computerWord) {
        char[] letterArray = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
        int dimension = (userWord.length() < computerWord.length()) ? userWord.length() : computerWord.length();
        for (int i = 0; i < dimension; i++) {
            if (userWord.charAt(i) == computerWord.charAt(i)) letterArray[i] = userWord.charAt(i);
        }
        return letterArray;
    }
}