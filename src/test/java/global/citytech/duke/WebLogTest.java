package global.citytech.duke;

import global.citytech.duke.webLog.WebLog;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class WebLogTest {

    @Test
    public void shortTestLogTesting() throws IOException, ParseException {
        ArrayList<WebLog> webLogsArrayList = new ArrayList<>();

        File file = new File("src/main/resources/webLogs/short-test_log.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            WebLog webLog = new WebLog(line);
            webLogsArrayList.add(webLog);

        }

        webLogsArrayList.forEach(item -> {
            System.out.println(item.toString());
        });
    }
}
