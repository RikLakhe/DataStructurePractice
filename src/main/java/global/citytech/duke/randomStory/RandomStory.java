package global.citytech.duke.randomStory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RandomStory {
    private final HashMap<String, WordList> randomHashmap = new HashMap<>();
    private final String[] fileName = {"adjective", "animal", "color", "country", "fruit", "timeframe"
            , "verb", "noun", "name", "number"};

    public void initialTesting() {
        throw new IllegalArgumentException("Test pass");
    }

    public RandomStory() throws IOException {
        initializeFromSource();
    }

    private void initializeFromSource() throws IOException {
        for (String file : fileName) {
            WordList wl = new WordList(file);
            randomHashmap.put(file, wl);
        }
    }

    public void printHashmap() {
        randomHashmap.forEach((key, value) -> {
            System.out.println(key + " ==== > " + value.getRandomWord());
        });
    }

    public void generateStory() throws IOException {
        String story;

        File file = new File("src/main/resources/randomStory/template.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            story = (sb.toString());

            for (String fileName : fileName) {
                story = story.replace("<" + fileName + ">", randomHashmap.get(fileName).getRandomWord());
            }

            System.out.println(" ===================== new =====================");
            System.out.println(story);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
