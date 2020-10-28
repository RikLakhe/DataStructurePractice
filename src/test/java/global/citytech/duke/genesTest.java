package global.citytech.duke;

import global.citytech.duke.genes.Genes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class genesTest {
    String testOne = "AATGCGTAATATGGT";
    String testTwo = "AATGCTAGGTTAATATGGT";
    String testThree = "ATCCTATGCTGTCTAAGGACTGCTGCTCTAATATGGT";
    String testNoGene = "GCTAGGCTTATGG";
    String testNoGene2 = "GCTAAGGCTTATGG";

    @Test(expected = IllegalArgumentException.class)
    public void initialTestingForTDD() {
        Genes genes = new Genes(testOne);
        genes.testingForTDD();
    }

//    @Test
//    public void positionOfAAT() {
//        Genes genes = new Genes(testOne);
//        int index = genes.getPositionOfAAT();
//        assertEquals(index, 0);
//    }
//
//    @Test
//    public void positionOfAATWhenNoAAT() {
//        Genes genes = new Genes(testNoGene);
//        int index = genes.getPositionOfAAT();
//        assertEquals(index, -1);
//    }
//
//    @Test
//    public void positionOfTAA() {
//        Genes genes = new Genes(testOne);
//        int index = genes.getPositionOfTAA();
//        assertEquals(index, 6);
//    }
//
//    @Test
//    public void positionOfTAAWhenNoTAA() {
//        Genes genes = new Genes(testNoGene);
//        int index = genes.getPositionOfTAA();
//        assertEquals(index, -1);
//    }

    @Test
    public void numberOfGenesWhenNoGeneTesting() {
        Genes genes = new Genes(testNoGene);
        int numberOfGenes = genes.getNumberOfGenes();
        assertEquals(numberOfGenes, 0);
    }

    @Test
    public void numberOfGenesWhenNoGene2Testing() {
        Genes genes = new Genes(testNoGene2);
        int numberOfGenes = genes.getNumberOfGenes();
        assertEquals(numberOfGenes, 0);
    }

    @Test
    public void numberOfGenesTesting() {
        Genes genes = new Genes("AATGCTAGGTAATATGGTATGCTAATGGTTACACTATGCTAATGGTTAAGGG");
        int numberOfGenes = genes.getNumberOfGenes();
        assertEquals(2, numberOfGenes);
    }

    @Test
    public void numberOfGenes2Testing() {
//        ATGATCGCTGATTAGGCTTAAATGACG
//        ^       ^X  ^Y    ^X ^X
        Genes genes = new Genes("ATGATCGCTGATTAGGCTTAAATGACG");
        int numberOfGenes = genes.getNumberOfGenes();
        assertEquals(1, numberOfGenes);
    }

    @Test
    public void numberOfGenes3Testing() {
        Genes genes = new Genes(
                "xxxATGxxxxxxxxxxxxxxxxxxTAGTAAxxxTGAxxxxxxATGxxxxxxTAAxxxxxxxxxATGxxxxxxxTAxxxxTGAxxTAG");
        int numberOfGenes = genes.getNumberOfGenes();
        assertEquals(3, numberOfGenes);
    }

    @Test
    public void numberOfCodonTesting() {
        Genes genes = new Genes(testThree);
        int numberOfCodon = genes.getNumbersOfCodon("CTG");
        assertEquals(1, numberOfCodon);
    }

    @Test
    public void testingPartTesting() {
        Genes genes = new Genes("");
        genes.testingParts(0,
                "ATGGGGCTTTACTGCGACTATCTGGCTTAA");    }
}