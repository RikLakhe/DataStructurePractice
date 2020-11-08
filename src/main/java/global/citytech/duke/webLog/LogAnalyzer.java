package global.citytech.duke.webLog;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LogAnalyzer {
    private ArrayList<WebLog> records;

    public LogAnalyzer() {
        this.records = new ArrayList<>();
    }

    public void readFile(String fileName) throws IOException, ParseException {
        File file = new File("src/main/resources/webLogs/" + fileName + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            WebLog webLog = new WebLog(line);
            records.add(webLog);
        }
    }

    public void printAll() {
        for (WebLog webLog : records) {
            System.out.println(webLog);
        }
    }

    public int getTotalRecords() {
        return records.size();
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueArrayList = new ArrayList<>();
        int count = 0;
        for (WebLog webLog : records) {
            if (!uniqueArrayList.contains(webLog.getIpAddress())) {
                uniqueArrayList.add(webLog.getIpAddress());
                System.out.println(webLog);
                count++;
            }
        }
        return count;
    }

    public int printAllHigherThanNum(int limit) {
        int count = 0;
        for (WebLog webLog : records) {
            if (webLog.getStatus() > limit) {
                System.out.println(webLog);
                count++;
            }
        }
        return count;
    }

    public int countUniqueIPsInRange(int lowerLimit, int upperLimit) {
        int count = 0;
        for (WebLog webLog : records) {
            if (webLog.getStatus() >= lowerLimit && webLog.getStatus() <= upperLimit) {
                System.out.println(webLog);
                count++;
            }
        }
        return count;
    }

    public int uniqueIPVisitsOnDay(String givenDate) throws ParseException {
        ArrayList<String> uniqueIps = new ArrayList<>();
        Date givenDateObj = new SimpleDateFormat("MMM dd").parse(givenDate);
        int count = 0;
        for (WebLog webLog : records) {
            if (
                    !uniqueIps.contains(webLog.getIpAddress()) &&
                            givenDateObj.getDate() == webLog.getDate().getDate() &&
                            givenDateObj.getMonth() == webLog.getDate().getMonth()
            ) {
                uniqueIps.add(webLog.getIpAddress());
                System.out.println(webLog.getIpAddress() + "::" + webLog.getDate().toString());
                count++;
            }
        }
        return count;
    }

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> uniqueIPs = new HashMap<>();

        for (WebLog webLog : records) {
            if (uniqueIPs.containsKey(webLog.getIpAddress())) {
                uniqueIPs.put(webLog.getIpAddress(), uniqueIPs.get(webLog.getIpAddress()) + 1);
            } else {
                uniqueIPs.put(webLog.getIpAddress(), 1);
            }
        }
        return uniqueIPs;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> uniqueRecords) {
        int max = 0;
        for (String recordKey : uniqueRecords.keySet()) {
            if (uniqueRecords.get(recordKey) >= max) {
                max = uniqueRecords.get(recordKey);
            }
        }

        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> uniqueRecords) {
        ArrayList<String> result = new ArrayList<>();
        for (String recordKey : uniqueRecords.keySet()) {
            if (uniqueRecords.get(recordKey) == mostNumberVisitsByIP(uniqueRecords)) {
                result.add(recordKey);
            }
        }

        return result;
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> ipsByDay = new HashMap<>();
        SimpleDateFormat sdfmt = new SimpleDateFormat("MMM dd");

        for (WebLog webLog : records) {
            if (ipsByDay.containsKey(sdfmt.format(webLog.getDate()))) {
                ArrayList<String> newIpList = ipsByDay.get(sdfmt.format(webLog.getDate()));
                newIpList.add(webLog.getIpAddress());
                ipsByDay.put(sdfmt.format(webLog.getDate()), newIpList);
            } else {
                ArrayList<String> newIpList = new ArrayList<>();
                newIpList.add(webLog.getIpAddress());
                ipsByDay.put(sdfmt.format(webLog.getDate()), newIpList);
            }
        }
        return ipsByDay;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> iPsForDaysHashMap) {
        String result = "";
        int max = 0;
        for (String day : iPsForDaysHashMap.keySet()) {
            if (iPsForDaysHashMap.get(day).size() >= max) {
                max = iPsForDaysHashMap.get(day).size();
                result = day;
            }
        }
        return result;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> iPsForDaysHashMap, String date) {
        HashMap<String, Integer> result = new HashMap<>();
        ArrayList<String> selectedDateArrayList = iPsForDaysHashMap.get(date);
        for (String ipAddress : selectedDateArrayList) {
            if (result.containsKey(ipAddress)) {
                result.put(ipAddress, result.get(ipAddress) + 1);
            } else {
                result.put(ipAddress, 1);
            }
        }

        int max = 0;
        for (String ipAddress : result.keySet()) {
            if (result.get(ipAddress) >= max) {
                max = result.get(ipAddress);
            }
        }

        ArrayList<String> returnArray = new ArrayList<>();
        for (String ipAddress : result.keySet()) {
            if (result.get(ipAddress) == max) {
                returnArray.add(ipAddress);
            }
        }

        return returnArray;
    }
}
