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
    public static void main(String[] args) throws IOException {
        CaeserCipher cs = new CaeserCipher();
//        WordGame wg = new WordGame();
//        File file = new File("src/main/resources/crypto/data1.txt");
//        File file = new File("src/main/resources/crypto/data2.txt");
//        File file = new File("src/main/resources/crypto/data3.txt");
//        File file = new File("src/main/resources/crypto/data4.txt");
//        File file = new File("src/main/resources/crypto/errors.txt");
//        File file = new File("src/main/resources/crypto/manywords.txt");
        File file = new File("src/main/resources/crypto/mysteryTwoKeysQuiz.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String[] inputParts;
            StringBuilder ss = new StringBuilder();


            while ((line = br.readLine()) != null) {
//                inputParts = line.split("<key>");
//                String data = cs.encrypt(inputParts[0], Integer.parseInt(inputParts[1]));
//                String data = cs.encrypt2(inputParts[0], Integer.parseInt(inputParts[1]),
//                        Integer.parseInt(inputParts[2]));
//                String data = cs.decrypt2(inputParts[0], Integer.parseInt(inputParts[1]),
//                        Integer.parseInt(inputParts[2]));

//                String data = cs.decrypt2(line);
                ss.append(line);
            }
            String data = cs.decrypt2(ss.toString());

//            WordGame wg = new WordGame();
//            while ((line = br.readLine()) != null) {
//                wg.addLine(line);
//            }
//            wg.findMostCommonWord();

            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}