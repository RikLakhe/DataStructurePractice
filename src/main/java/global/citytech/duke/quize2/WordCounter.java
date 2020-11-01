package global.citytech.duke.quize2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class WordCounter {
    private ArrayList<String> wordArrayList;
    private ArrayList<Integer> freqArrayList;
    private ArrayList<String> charactersArrayList;
    private ArrayList<Integer> freqCharactersArrayList;

    public WordCounter() {
        wordArrayList = new ArrayList<String>();
        freqArrayList = new ArrayList<Integer>();
        charactersArrayList = new ArrayList<String>();
        freqCharactersArrayList = new ArrayList<Integer>();
    }

    public void setWordArrayList(String inputLine) {
//        String[] matches = Pattern.compile("[A-Za-z]{1,}")
        String[] matches = Pattern.compile("(\\.|\\,|\\;|\\<|\\>){0,}([A-Za-z]{1,}(\\.|\\,|\\;|\\<|\\>){0,})")
                .matcher(inputLine.toLowerCase())
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        for (String word : matches) {
            int wordIndex = wordArrayList.indexOf(word);
            if (wordIndex == -1) {
                wordArrayList.add(word);
                freqArrayList.add(0);
            } else {
                int wordCounts = freqArrayList.get(wordIndex);
                freqArrayList.set(wordIndex, wordCounts + 1);
            }
        }
    }

    public void setCharactersArrayList(String inputLine) {
        String[] matches = Pattern.compile("[A-Z]{1,}\\.")
                .matcher(inputLine)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        for (String word : matches) {

            int wordIndex = charactersArrayList.indexOf(word);
            if (wordIndex == -1) {
                charactersArrayList.add(word);
                freqCharactersArrayList.add(0);
            } else {
                int wordCounts = freqCharactersArrayList.get(wordIndex);
                freqCharactersArrayList.set(wordIndex, wordCounts + 1);
            }
        }
    }

    public void printCharactersFrequency() {
        for (int k = 0; k < charactersArrayList.size(); k++) {
            System.out.println((k + 1) + ". " + charactersArrayList.get(k) + "===>" + freqCharactersArrayList.get(k));
        }
//        int temp = maxIndex();
//        System.out.println("Max word is ===>(" + wordArrayList.get(temp) + "," + freqArrayList.get(temp) + ")");
    }

    public void printWordsWithFrequency() {
        printTotalUnique();
        for (int k = 0; k < wordArrayList.size(); k++) {
            System.out.println((k + 1) + ". " + wordArrayList.get(k) + "===>" + freqArrayList.get(k));
        }
        int temp = maxIndex();
        System.out.println("Max word is ===>(" + wordArrayList.get(temp) + "," + freqArrayList.get(temp) + ")");
    }

    private void printTotalUnique() {
        System.out.println("unique words=>" + wordArrayList.size());
    }

    private int maxIndex() {
        int highestFreq = Collections.max(freqArrayList);
        return freqArrayList.indexOf(highestFreq);
    }

    public void charactersWithNumParts(int num1, int num2) {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();

        for (int k = 0; k < freqCharactersArrayList.size(); k++) {
            if (freqCharactersArrayList.get(k) >= num1 && freqCharactersArrayList.get(k) <= num2) {
                temp.put(charactersArrayList.get(k), freqCharactersArrayList.get(k));
            }
        }

        temp.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
