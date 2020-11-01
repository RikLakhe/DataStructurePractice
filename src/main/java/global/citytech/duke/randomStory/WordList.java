package global.citytech.duke.randomStory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
    private ArrayList<String> listOfWord = new ArrayList<>();

    public WordList(String fileName) throws IOException {
        listOfWord.clear();
        File file = new File("src/main/resources/randomStory/" + fileName + "List.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                listOfWord.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printWord() {
        listOfWord.forEach(System.out::println);
    }

    public String getRandomWord() {
        int random = (int) (Math.random() * (listOfWord.size() - 1) + 1);
        String returnWord = listOfWord.get(random);
        listOfWord.remove(random);
        return returnWord;
    }
}
