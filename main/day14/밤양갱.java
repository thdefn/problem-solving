package main.day14;

import java.util.Scanner;

// 17636 168
public class 밤양갱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        long sec = 9;
        long lenOfInput = "daldidalgo".length();
        long lenOfLyrics = (N + 1) * lenOfInput;
        while (lenOfInput < lenOfLyrics) {
            lenOfInput = lenOfInput * 2;
            sec++;
        }

        System.out.println(sec);
    }
}
