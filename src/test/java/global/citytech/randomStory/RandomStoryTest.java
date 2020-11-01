package global.citytech.randomStory;

import global.citytech.duke.randomStory.RandomStory;
import org.junit.Test;

import java.io.IOException;

public class RandomStoryTest {
    RandomStory rs = new RandomStory();

    public RandomStoryTest() throws IOException {
    }

    @Test(expected = IllegalArgumentException.class)
    public void initialTesting() {
        rs.initialTesting();
    }

    @Test
    public void printHashmapTest() throws IOException {
        rs.printHashmap();
    }

    @Test
    public void generateStoryTest() throws IOException {
        rs.generateStory();
    }
}
