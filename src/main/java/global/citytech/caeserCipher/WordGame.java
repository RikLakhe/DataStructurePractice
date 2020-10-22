package global.citytech.caeserCipher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

class WordCounts {
    private int wordLength;
    private int count;

    public WordCounts(int wordLength, int count) {
        this.wordLength = wordLength;
        this.count = count;
    }

    public int getWordLength() {
        return wordLength;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count += 1;
    }
}

public class WordGame {
    private List<WordCounts> countList = new ArrayList<WordCounts>();

    public WordGame() {
    }

    private int findWordCountsObjectWithLength(int len) {
        if (countList.size() == 0) {
            return -1;
        } else {
            for (int k = 0; k < countList.size(); k++) {
                if (countList.get(k).getWordLength() == len) {
                    return k;
                }
            }
            return -1;
        }
    }

    private boolean checkWordCountsObjectWithLength(int len) {
        if (countList.size() == 0) {
            return false;
        } else {
            for (WordCounts word : countList) {
                if (word.getWordLength() == len) {
                    return true;
                }
            }
            return false;
        }
    }

    public void addLine(String inputString) {
        String[] matches = Pattern.compile("[A-Za-z]{1,}").matcher(inputString).results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        for (String match : matches) {
            System.out.println("word=>" + match + "leng=>" + match.length());
            if (checkWordCountsObjectWithLength(match.length())) {
                int countListIndex = findWordCountsObjectWithLength(match.length());
                WordCounts foundWC = countList.get(countListIndex);
                foundWC.addCount();
            } else {
                WordCounts wc = new WordCounts(match.length(), 1);
                countList.add(wc);
            }
        }
    }

    public void findMostCommonWord() {
        int highestCount = 0;
        int highestLength = 0;
        for (WordCounts word : countList) {
            System.out.println("here==>" + word.getWordLength() + ", count==>" + word.getCount());
            if(word.getCount()>highestCount){
                highestCount=word.getCount();
                highestLength=word.getWordLength();
            }
        }
        System.out.println("most==>" +highestLength);

    }
}
