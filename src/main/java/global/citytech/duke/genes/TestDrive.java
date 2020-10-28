package global.citytech.duke.genes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestDrive {
    public static void main(String[] args) throws IOException {

//        File file = new File("src/main/resources/gene/Axl2p.fa");
        File file = new File("src/main/resources/gene/GRch38dnapart.fa");

        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line.toUpperCase());
            }

            Genes genes = new Genes(builder.toString());

            System.out.println("Size = "+genes.getNumberOfGenes());
            System.out.println("getNumbersOfGenesGreaterThanLimiter = "+genes.getNumbersOfGenesGreaterThanLimiter(60));
            System.out.println("getLongestGenes = "+genes.getLongestGenes());
            System.out.println("getNumberOfGenesByCGRatioLimiter = "+genes.getNumberOfGenesByCGRatioLimiter(0.35f));
            System.out.println("getNumbersOfCodon ="+genes.getNumbersOfCodon("CTG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
