package global.citytech.duke.randomStory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class WordCounter2 {
    private HashMap<String,Integer> wordMap = new HashMap<>();
    private String[] fileList = {
            "caesar","confucius","errors","hamlet","likeit","macbeth","romeo"
    };

    public WordCounter2() throws IOException {
        initialize();
    }

    private void initialize()  throws IOException {
        int target = 1;

        for(String fileName : fileList){
            File file = new File("src/main/resources/randomStory/"+fileName+".txt");

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] matches = Pattern.compile("([A-Za-z]{1,})")
                            .matcher(line.toLowerCase())
                            .results()
                            .map(MatchResult::group)
                            .toArray(String[]::new);

                    for (String match:matches){
                        if(!wordMap.containsKey(match)){wordMap.put(match,target);}
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            target++;
        }
    }

    public void displayAll(){
        wordMap.forEach((key,value)-> System.out.println("Key="+key+", Value=>"+value));
    }

    public void displayAll(int limit){
        AtomicInteger count = new AtomicInteger();
        wordMap.forEach((key,value)-> {
            if(limit==value){
                System.out.println("Key="+key+", Value=>"+value);
                count.getAndIncrement();

            }
        });
        System.out.println(count);
    }
}
