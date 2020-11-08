package global.citytech.randomStory;

import global.citytech.duke.randomStory.WordCounter2;
import org.junit.Test;

import java.io.IOException;

public class WordCounter2Test {
    WordCounter2 wc2 = new WordCounter2();

    public WordCounter2Test() throws IOException {
    }

    @Test
    public void displayAllTesting(){
        wc2.displayAll();
    }

    @Test
    public void displayAll2Testing(){
        wc2.displayAll(7);
    }
}
