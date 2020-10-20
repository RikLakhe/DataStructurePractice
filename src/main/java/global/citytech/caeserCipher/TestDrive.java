package global.citytech.caeserCipher;

import global.citytech.duke.quize1.Point;
import global.citytech.duke.quize1.Shape;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDrive {
    public static void main(String[] args)  throws IOException {
        CaeserCipher cs = new CaeserCipher();

//        File file = new File("src/main/resources/crypto/date1.txt");
//        File file = new File("src/main/resources/crypto/date2.txt");
//        File file = new File("src/main/resources/crypto/data3.txt");
        File file = new File("src/main/resources/crypto/errors.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String[] inputParts;
            while ((line = br.readLine()) != null) {
//                inputParts = line.split("<key>");
//                String data = cs.decrypt2(inputParts[0], Integer.parseInt(inputParts[1]),
//                        Integer.parseInt(inputParts[2]));
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}