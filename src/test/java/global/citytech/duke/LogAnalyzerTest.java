package global.citytech.duke;

import global.citytech.duke.webLog.LogAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class LogAnalyzerTest {
    String file = "short-test_log";
    String weblog3 = "weblog3-short_log";
    LogAnalyzer logAnalyzer = new LogAnalyzer();

    @Test
    public void readFileTesting() throws IOException, ParseException {
        logAnalyzer.readFile(file);
        Assert.assertEquals(7, logAnalyzer.getTotalRecords());
    }

    @Test
    public void getTotalRecordsTesting() throws IOException, ParseException {
        logAnalyzer.readFile(file);
        Assert.assertEquals(7, logAnalyzer.getTotalRecords());
    }

    @Test
    public void getTotalUniqueIpsTesting() throws IOException, ParseException {
        logAnalyzer.readFile(file);
        Assert.assertEquals(4, logAnalyzer.countUniqueIPs());
    }

    @Test
    public void printAllHigherThanNumTesting() throws IOException, ParseException {
        logAnalyzer.readFile(file);
        Assert.assertEquals(3, logAnalyzer.printAllHigherThanNum(200));
    }

    @Test
    public void countUniqueIPsInRangeTesting() throws IOException, ParseException {
        logAnalyzer.readFile(file);
        Assert.assertEquals(4, logAnalyzer.countUniqueIPsInRange(200, 299));
    }

    @Test
    public void uniqueIPVisitsOnDayTesting() throws IOException, ParseException {
        logAnalyzer.readFile(file);
        Assert.assertEquals(4, logAnalyzer.uniqueIPVisitsOnDay("Sep 30"));
    }

    @Test
    public void mostNumberVisitsByIPTesting() throws IOException, ParseException {
        logAnalyzer.readFile(weblog3);
        int expected = logAnalyzer.mostNumberVisitsByIP(logAnalyzer.countVisitsPerIP());
        Assert.assertEquals(expected, 3);
    }

    @Test
    public void iPsMostVisitsTesting() throws IOException, ParseException {
        logAnalyzer.readFile(weblog3);
        ArrayList<String> expected = logAnalyzer.iPsMostVisits(logAnalyzer.countVisitsPerIP());
        for (String ip : expected) {
            System.out.println(ip);
        }
        Assert.assertEquals(expected.size(), 2);
    }

    @Test
    public void iPsForDaysTesting() throws IOException, ParseException {
        logAnalyzer.readFile(weblog3);
        HashMap<String, ArrayList<String>> test = logAnalyzer.iPsForDays();

        Assert.assertEquals(test.size(), 3);
    }

    @Test
    public void dayWithMostIPVisitsTesting() throws IOException, ParseException {
        logAnalyzer.readFile(weblog3);
        String result = logAnalyzer.dayWithMostIPVisits(logAnalyzer.iPsForDays());

        Assert.assertEquals(result, "Sep 30");
    }

    @Test
    public void iPsWithMostVisitsOnDayTesting() throws IOException, ParseException {
        logAnalyzer.readFile(weblog3);
        ArrayList<String> result = logAnalyzer.iPsWithMostVisitsOnDay(logAnalyzer.iPsForDays(),"Sep 30");

        Assert.assertEquals(result.size(),2);
    }

    @Test
    public void quizCountUniqueIPsTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        int result = logAnalyzer.countUniqueIPs();

        Assert.assertEquals(result,45);
    }

    @Test
    public void quizUniqueIPVisitsOnDayTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        int result = logAnalyzer.uniqueIPVisitsOnDay("Sep 27");

        Assert.assertEquals(result,8);
    }

    @Test
    public void quizCountUniqueIPsInRangeTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        int result = logAnalyzer.countUniqueIPsInRange(200,299);

        Assert.assertEquals(result,349);
    }

    @Test
    public void quizMostNumberVisitsByIPTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        int result = logAnalyzer.mostNumberVisitsByIP(logAnalyzer.countVisitsPerIP());

        Assert.assertEquals(result,63);
    }

    @Test
    public void quizIPsMostVisitsTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        ArrayList<String> result = logAnalyzer.iPsMostVisits(logAnalyzer.countVisitsPerIP());

        for(String res: result){
            System.out.println(res);
        }
        Assert.assertEquals(result.size(),1);
    }

    @Test
    public void quizDayWithMostIPVisitsTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        String result = logAnalyzer.dayWithMostIPVisits(logAnalyzer.iPsForDays());

        Assert.assertEquals(result,"Sep 24");
    }

    @Test
    public void quizIPsWithMostVisitsOnDayTesting() throws IOException, ParseException {
        String file = "weblog2_log";
        logAnalyzer.readFile(file);
        ArrayList<String> result = logAnalyzer.iPsWithMostVisitsOnDay(logAnalyzer.iPsForDays(),"Sep 30");
        for(String res: result){
            System.out.println(res);
        }
        Assert.assertEquals(result.size(),2);
    }
}
