package global.citytech.duke.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;

public class WeatherCSV {
    private CSVParser records;
    private CSVRecord resultRecord;

    public WeatherCSV() {
    }

    public File[] readAllFiles(String directoryName) throws NullPointerException, IOException {
        File[] files = new File("src/main/resources/csvFiles/nc_weather/" + directoryName).listFiles();

        return files;
//        assert files != null;
//        for (File file : files) {
//            if (file.isFile()) {
//                System.out.println(file.getName());
//                BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/csvFiles" +
//                        "/nc_weather/" + directoryName + "/" + file.getName())));
//                this.records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
//            }
//        }
    }

    public CSVParser readSingleFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/csvFiles" +
                "/nc_weather/" + fileName)));
        return CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
    }

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord currentRecord = null;
        CSVRecord coldRecord = null;
        for (CSVRecord record : parser) {
            currentRecord = record;
            if (coldRecord == null) {
                coldRecord = currentRecord;
            } else {
                if (!coldRecord.get("TemperatureF").equals("-9999")) {
                    if (Double.parseDouble(coldRecord.get("TemperatureF")) > Double.parseDouble(currentRecord.get(
                            "TemperatureF"))) {
                        coldRecord = currentRecord;
                    }
                }
            }
        }
//        System.out.println("The cold temperature was at " + coldRecord.get("DateUTC") + " and temperature was" +
//        coldRecord.get("TemperatureF"));
        return coldRecord;
    }

    public void printTemperatureOfDay(CSVParser parser) throws IOException {
        for (CSVRecord record : parser) {
            System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
        }
    }

    public void fileWithColdestTemperature(File[] files) throws IOException {
        CSVRecord coldRecord = null;
        String coldestFileName = null;
        ArrayList<String> fileList = new ArrayList<>() {{
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                    add("2013/" + file.getName());
                }
            }
        }};

        for (String fileName : fileList) {
            if (coldRecord == null) {
                coldestFileName = fileName;
                coldRecord = coldestHourInFile(readSingleFile(fileName));
            } else {
                if (Double.parseDouble(coldRecord.get("TemperatureF")) > Double.parseDouble(coldestHourInFile(readSingleFile(fileName)).get("TemperatureF"))) {
                    coldRecord = coldestHourInFile(readSingleFile(fileName));
                    coldestFileName = fileName;
                }
            }
        }

        System.out.println("Coldest day was in file " + coldestFileName);
        System.out.println("Coldest temperature on that day was " + coldestHourInFile(readSingleFile(coldestFileName)).get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        printTemperatureOfDay(readSingleFile(coldestFileName));
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord currentRecord = null;
        CSVRecord lowHumidityRecord = null;
        for (CSVRecord record : parser) {
            currentRecord = record;
            if (lowHumidityRecord == null) {
                lowHumidityRecord = currentRecord;
            } else {
                if (!lowHumidityRecord.get("Humidity").equals("N/A")) {
                    if (Double.parseDouble(lowHumidityRecord.get("Humidity")) > Double.parseDouble(currentRecord.get(
                            "Humidity"))) {
                        lowHumidityRecord = currentRecord;
                    }
                }
            }
        }
//        System.out.println("The cold temperature was at " + coldRecord.get("DateUTC") + " and temperature was" +
//        coldRecord.get("TemperatureF"));
        return lowHumidityRecord;
    }

    public void lowestHumidityInManyFiles(File[] files) throws IOException {
        CSVRecord lowHumidityRecord = null;
        String lowestHumidityFileName = null;
        ArrayList<String> fileList = new ArrayList<>() {{
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                    add("2013/" + file.getName());
                }
            }
        }};

        for (String fileName : fileList) {
            if (lowHumidityRecord == null) {
                lowestHumidityFileName = fileName;
                lowHumidityRecord = lowestHumidityInFile(readSingleFile(fileName));
            } else {
                if (Double.parseDouble(lowHumidityRecord.get("Humidity")) > Double.parseDouble(lowestHumidityInFile(readSingleFile(fileName)).get("Humidity"))) {
                    lowHumidityRecord = lowestHumidityInFile(readSingleFile(fileName));
                    lowestHumidityFileName = fileName;
                }
            }
        }

        System.out.println("Lowest Humidity was " + lowestHumidityInFile(readSingleFile(lowestHumidityFileName)).get(
                "Humidity") + " at " + lowestHumidityInFile(readSingleFile(lowestHumidityFileName)).get(
                "DateUTC"));
        printTemperatureOfDay(readSingleFile(lowestHumidityFileName));
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double result = 0;
        int totalRecords = 0;
        for (CSVRecord record : parser) {
            totalRecords++;
            result += Double.parseDouble(record.get("TemperatureF"));
        }
        return result / totalRecords;
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, Integer value) {
        double result = 0;
        int totalRecords = 0;
        for (CSVRecord record : parser) {
            if (Double.parseDouble(record.get("Humidity")) >= value) {
                totalRecords++;
                result += Double.parseDouble(record.get("TemperatureF"));
            }
        }
        return result > 0 && totalRecords > 0 ? result / totalRecords : 0;
    }
}
