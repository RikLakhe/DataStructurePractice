package global.citytech.miniProject;

import global.citytech.miniProject.babyName.BabyName;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BabyNameTest {
    private static final double DELTA = 1e-15;
    BabyName babyName = new BabyName();

    @Test
    public void totalBirthsTesting() throws IOException {
        int result = babyName.totalBirths("test","example-small.csv");
        assertEquals(result,1700);
    }

    @Test
    public void totalBirthsInDirectoryTesting() throws IOException {
        int result = babyName.totalBirths("test");
        assertEquals(result,1903);
    }

    @Test
    public void getRankTesting() throws IOException {
        int result = babyName.getRank(2012,"Mason","M");
        assertEquals(result,2);
    }

    @Test
    public void getRankNoNameTesting() throws IOException {
        int result = babyName.getRank(2012,"NoName","M");
        assertEquals(result,-1);
    }

    @Test
    public void getNameTesting() throws IOException {
        String result = babyName.getName(2012,2,"M");
        assertEquals(result,"Mason");
    }

    @Test
    public void getNameNoRankTesting() throws IOException {
        String result = babyName.getName(2012,100,"M");
        assertEquals(result,"NO NAME");
    }

    @Test
    public void whatIsNameInYearTesting() throws IOException {
        String result = babyName.whatIsNameInYear("Isabella",2012,2014,"F");
        assertEquals(result,"Sophia");
    }

    @Test
    public void yearOfHighestRankTesting() throws IOException {
        int result = babyName.yearOfHighestRank("Mason","M");
        assertEquals(result,2);
    }

    @Test
    public void getAverageRankTesting() throws IOException {
        double result = babyName.getAverageRank("Jacob","M");
        assertEquals(result,3.0, DELTA);
    }

    @Test
    public void getTotalBirthsRankedHigherTesting() throws IOException {
        int result = babyName.getTotalBirthsRankedHigher(2012,"Ethan","M");
        assertEquals(result,15);
    }


    @Test
    public void q1Testing() throws IOException {
        int result = babyName.totalGender("by_year","yob1900.csv","F");
        assertEquals(result,299828);
    }

    @Test
    public void q2Testing() throws IOException {
        int result = babyName.totalGender("by_year","yob1905.csv","M");
        assertEquals(result,132319);
    }

    @Test
    public void q3Testing() throws IOException {
        int result = babyName.getRankQuestion(1960,"Emily","F");
        assertEquals(result,251);
    }

    @Test
    public void q4Testing() throws IOException {
        int result = babyName.getRankQuestion(1971,"Frank","M");
        assertEquals(result,54);
    }

    @Test
    public void q5Testing() throws IOException {
        String result = babyName.getNameQuestion(1980,350,"F");
        assertEquals(result,"Mia");
    }

    @Test
    public void q6Testing() throws IOException {
        String result = babyName.getNameQuestion(1982,450,"M");
        assertEquals(result,"Forrest");
    }

    @Test
    public void q7Testing() throws IOException {
        String result = babyName.whatIsNameInYearQuestion("Susan",1972,2014,"F");
        assertEquals(result,"Addison");
    }

    @Test
    public void q8Testing() throws IOException {
        String result = babyName.whatIsNameInYearQuestion("Owen",1974,2014,"M");
        assertEquals(result,"Leonel");
    }

    @Test
    public void q9Testing() throws IOException {
        int result = babyName.yearOfHighestRankQuestion("Genevieve","F");
        assertEquals(result,76);
    }

//    @Test
//    public void q10Testing() throws IOException {
//        int result = babyName.yearOfHighestRankQuestion("Mich","M");
//        assertEquals(result,76);
//    }

    @Test
    public void q11Testing() throws IOException {
        double result = babyName.getAverageRankQuestion("Susan","F");
        assertEquals(result,173.51111111111112,DELTA);
    }

    @Test
    public void q12Testing() throws IOException {
        double result = babyName.getAverageRankQuestion("Robert","M");
        assertEquals(result,10.755555555555556,DELTA);
    }

    @Test
    public void q13Testing() throws IOException {
        double result = babyName.getTotalBirthsRankedHigherQuestion(1990,"Emily","F");
        assertEquals(result,323200.0,DELTA);
    }

    @Test
    public void q14Testing() throws IOException {
        double result = babyName.getTotalBirthsRankedHigherQuestion(1990,"Drew","M");
        assertEquals(result,1498074.0,DELTA);
    }

}
