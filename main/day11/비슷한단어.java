package main.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 비슷한단어 {
    static class Word {
        int index;
        String word;

        Word(int index, String word) {
            this.index = index;
            this.word = word;
        }

        @Override
        public String toString() {
            return index + " " + word;
        }
    }

    static class WordComparator implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            return o1.index - o2.index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Word[] words = new Word[N];
        for (int i = 0; i < N; i++) {
            words[i] = new Word(i, br.readLine());
        }
        Arrays.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.word.compareTo(o2.word);
            }
        });


        WordComparator wordComparator = new WordComparator();

        int maxPrefix = 0;
        Word beforeWord = words[0];
        Queue<Word> answerCandidate = new PriorityQueue<>(wordComparator);
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            String before = beforeWord.word;
            String cur = words[i].word;
            while (j < before.length() && j < cur.length()) {
                if (before.charAt(j) != cur.charAt(j))
                    break;
                j++;
            }
            if (j > maxPrefix) {
                maxPrefix = j;
                answerCandidate = new PriorityQueue<>(wordComparator);
                answerCandidate.add(beforeWord);
                answerCandidate.add(words[i]);
            } else if (j == maxPrefix && !answerCandidate.isEmpty()) {
                if (beforeWord == answerCandidate.peek()) {
                    answerCandidate.add(words[i]);
                } else if (answerCandidate.peek().index > beforeWord.index) {
                    answerCandidate = new PriorityQueue<>(wordComparator);
                    answerCandidate.add(beforeWord);
                    answerCandidate.add(words[i]);
                }
            } else beforeWord = words[i];
        }


        for (int i = 0; i < 2; i++) {
            System.out.println(answerCandidate.poll().word);
        }


    }
}
