package main.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        int maxPrefix = 0;
        Word beforeWord = words[0];
        List<Word> answerCandidate = new ArrayList<>();
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
                answerCandidate = new ArrayList<>();
                answerCandidate.add(beforeWord);
                answerCandidate.add(words[i]);
            } else if (j == maxPrefix) {
                if (answerCandidate.isEmpty()) {
                    answerCandidate.add(beforeWord);
                    answerCandidate.add(words[i]);
                } else if (beforeWord != answerCandidate.get(0) && answerCandidate.get(0).index > beforeWord.index) {
                    answerCandidate = new ArrayList<>();
                    answerCandidate.add(beforeWord);
                    answerCandidate.add(words[i]);
                } else {
                    answerCandidate.add(words[i]);
                }
            } else beforeWord = words[i];
        }

        Collections.sort(answerCandidate, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.index - o2.index;
            }
        });

        System.out.println(answerCandidate);


    }
}
