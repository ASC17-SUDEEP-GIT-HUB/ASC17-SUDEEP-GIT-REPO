package com.demo.lab1;
import java.util.*;

public class Words {

    public int numberOfWords(String sentence) {
        String [] arr = sentence.trim().split(" ");
        int count = 0;

        for(String word : arr) {

            if(!word.matches("\\d+")) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the sentence: ");
        String userSentence = sc.nextLine();

        Words w = new Words();

        System.out.println(w.numberOfWords(userSentence));
    }
}
