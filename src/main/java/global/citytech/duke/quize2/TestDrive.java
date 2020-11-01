package global.citytech.duke.quize2;

import global.citytech.duke.quize1.Point;
import global.citytech.duke.quize1.Shape;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class TestDrive {
    public static void main(String[] args) throws IOException {
        WordCounter wc = new WordCounter();

        File file = new File("src/main/resources/crypto/errors.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
//                wc.setWordArrayList(line);
                wc.setCharactersArrayList(line);
            }

//            wc.printWordsWithFrequency();
//            wc.printCharactersFrequency();
            wc.charactersWithNumParts(10,15);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
