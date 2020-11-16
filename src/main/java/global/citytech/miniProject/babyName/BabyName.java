package global.citytech.miniProject.babyName;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class BabyName {

    public BabyName() {
    }

    public File[] readAllFilesDirectory(String directoryName) throws NullPointerException {
        return new File("src/main/resources/babyNames/us_babynames_" + directoryName).listFiles();
    }

    public CSVParser readSingleFile(String directory, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + directory + "/" + fileName)));
        return CSVFormat.EXCEL.parse(reader);
    }

    public int totalBirths(String directory, String fileName) throws IOException {
        int total = 0;
        int totalBoyBirths = 0;
        int totalGirlBirths = 0;
        int totalBoy = 0;
        int totalGirl = 0;
        int totalNames = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + directory + "/" + fileName)));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            totalNames += 1;
            total += Integer.parseInt(record.get(2));
            if (record.get(1).toUpperCase().equals("M")) {
                totalBoy += 1;
                totalBoyBirths += Integer.parseInt(record.get(2));
            }
            if (record.get(1).toUpperCase().equals("F")) {
                totalGirl += 1;
                totalGirlBirths += Integer.parseInt(record.get(2));
            }
        }
        System.out.println("Total Births =" + total);
        System.out.println("Total Boy Names=" + totalBoy + " total births=>" + totalBoyBirths);
        System.out.println("Total Girls Names=" + totalGirl + " total births=>" + totalGirlBirths);
        System.out.println("Total Names =" + totalNames);
        return total;
    }

    public int totalBirths(String directory) throws IOException {
        int total = 0;
        int totalBoyBirths = 0;
        int totalGirlBirths = 0;
        int totalBoy = 0;
        int totalGirl = 0;
        int totalNames = 0;
        File[] files = readAllFilesDirectory(directory);
        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                    "/us_babynames_" + directory + "/" + file.getName())));
            CSVParser records = CSVFormat.EXCEL.parse(reader);
            for (CSVRecord record : records) {
                totalNames += 1;
                total += Integer.parseInt(record.get(2));
                if (record.get(1).toUpperCase().equals("M")) {
                    totalBoy += 1;
                    totalBoyBirths += Integer.parseInt(record.get(2));
                }
                if (record.get(1).toUpperCase().equals("F")) {
                    totalGirl += 1;
                    totalGirlBirths += Integer.parseInt(record.get(2));
                }
            }
        }
        System.out.println("Total Births =" + total);
        System.out.println("Total Boy Names=" + totalBoy + " total births=>" + totalBoyBirths);
        System.out.println("Total Girls Names=" + totalGirl + " total births=>" + totalGirlBirths);
        System.out.println("Total Names =" + totalNames);
        return total;
    }

    public int totalGender(String directory, String fileName, String gender) throws IOException {
        int total = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + directory + "/" + fileName)));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                total += Integer.parseInt(record.get(2));
            }
        }
        return total;
    }

    public int getRank(int year, String name, String gender) throws IOException {
        int rank = -1;
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + "test" + "/yob" + year + "short.csv")));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                counter += 1;
                if (name.toUpperCase().equals(record.get(0).toUpperCase())) {
                    rank = counter;
                }
            }
        }
        return rank;
    }

    public int getRankQuestion(int year, String name, String gender) throws IOException {
        int rank = -1;
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_by_year/yob" + year + ".csv")));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                counter += 1;
                if (name.toUpperCase().equals(record.get(0).toUpperCase())) {
                    rank = counter;
                }
            }
        }
        return rank;
    }

    public String getName(int year, int rank, String gender) throws IOException {
        String name = "NO NAME";
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + "test" + "/yob" + year + "short.csv")));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                counter += 1;
                if (counter == rank) {
                    name = record.get(0);
                }
            }
        }
        return name;
    }

    public String getNameQuestion(int year, int rank, String gender) throws IOException {
        String name = "NO NAME";
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_by_year/yob" + year + ".csv")));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                counter += 1;
                if (counter == rank) {
                    name = record.get(0);
                }
            }
        }
        return name;
    }

    public String whatIsNameInYear(String name, int year, int newYear, String gender) throws IOException {
        String result = getName(newYear, getRank(year, name, gender), gender);
        System.out.println(name + " born in " + year + " would be " + result + "if " + (gender.equals("M") ? "he" :
                "she") + " was born" +
                " in " + newYear);
        return result;
    }

    public String whatIsNameInYearQuestion(String name, int year, int newYear, String gender) throws IOException {
        String result = getNameQuestion(newYear, getRankQuestion(year, name, gender), gender);
        System.out.println(name + " born in " + year + " would be " + result + "if " + (gender.equals("M") ? "he" :
                "she") + " was born" +
                " in " + newYear);
        return result;
    }

    private int getRankByFileName(String fileName, String name, String gender) throws IOException {
        int rank = -1;
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + "test" + "/" + fileName)));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                counter += 1;
                if (name.toUpperCase().equals(record.get(0).toUpperCase())) {
                    rank = counter;
                }
            }
        }
        return rank;
    }

    private int getRankByFileNameQuestion(String fileName, String name, String gender) throws IOException {
        int rank = -1;
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_by_year/" + fileName)));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                counter += 1;
                if (name.toUpperCase().equals(record.get(0).toUpperCase())) {
                    rank = counter;
                }
            }
        }
        return rank;
    }

    public int yearOfHighestRank(String name, String gender) throws IOException {
        HashMap<String, Integer> result = new HashMap<>();
        File[] files = readAllFilesDirectory("test");
        for (File file : files) {
            int ranked = getRankByFileName(file.getName(), name, gender);
            result.put(file.getName(), ranked);
        }
//        result.keySet().forEach(keys -> {
//            System.out.println("data===>" + keys + "," + result.get(keys));
//        });


        int topRank = 0;
        String resultFile = "";
        Set<String> resultArray = result.keySet();
        for (String item : resultArray) {
            if (topRank == 0) {
                topRank = result.get(item);
                resultFile = item;
            } else {
                if (result.get(item) < topRank) {
                    topRank = result.get(item);
                    resultFile = item;
                }
            }
        }
        System.out.println("ANSWER =>" + topRank + "    at:" + resultFile);
        return topRank;
    }

    public int yearOfHighestRankQuestion(String name, String gender) throws IOException {
        HashMap<String, Integer> result = new HashMap<>();
        File[] files = readAllFilesDirectory("by_year");
        for (File file : files) {
            int ranked = getRankByFileNameQuestion(file.getName(), name, gender);
            result.put(file.getName(), ranked);
        }
        result.keySet().forEach(keys -> {
            System.out.println("data===>" + keys + "," + result.get(keys));
        });


        int topRank = 0;
        String resultFile = "";
        Set<String> resultArray = result.keySet();
        for (String item : resultArray) {
            if (topRank == 0) {
                topRank = result.get(item);
                resultFile = item;
            } else {
                if (result.get(item) < topRank) {
                    topRank = result.get(item);
                    resultFile = item;
                }
            }
        }
        System.out.println("ANSWER =>" + topRank + "    at:" + resultFile);
        return topRank;
    }

    public double getAverageRank(String name, String gender) throws IOException {
        HashMap<String, Integer> result = new HashMap<>();
        File[] files = readAllFilesDirectory("test");
        for (File file : files) {
            int ranked = getRankByFileName(file.getName(), name, gender);
            result.put(file.getName(), ranked);
        }
        result.keySet().forEach(keys -> {
            System.out.println("data===>" + keys + "," + result.get(keys));
        });


        int totalRank = 0;
        int totalCounts = 0;
        for (String item : result.keySet()) {
            totalRank += result.get(item);
            totalCounts += 1;
        }
        return (double) totalRank / totalCounts;
    }
public double getAverageRankQuestion(String name, String gender) throws IOException {
        HashMap<String, Integer> result = new HashMap<>();
        File[] files = readAllFilesDirectory("by_year");
        for (File file : files) {
            int ranked = getRankByFileNameQuestion(file.getName(), name, gender);
            result.put(file.getName(), ranked);
        }
        result.keySet().forEach(keys -> {
            System.out.println("data===>" + keys + "," + result.get(keys));
        });


        int totalRank = 0;
        int totalCounts = 0;
        for (String item : result.keySet()) {
            totalRank += result.get(item);
            totalCounts += 1;
        }
        return (double) totalRank / totalCounts;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) throws IOException {
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_" + "test" + "/yob" + year + "short.csv")));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                if (!name.toUpperCase().equals(record.get(0).toUpperCase())) {
                    counter += Integer.parseInt(record.get(2));
                } else {
                    break;
                }
            }
        }
        return counter;
    }

    public int getTotalBirthsRankedHigherQuestion(int year, String name, String gender) throws IOException {
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/babyNames" +
                "/us_babynames_by_year/yob" + year + ".csv")));
        CSVParser records = CSVFormat.EXCEL.parse(reader);
        for (CSVRecord record : records) {
            if (gender.toUpperCase().equals(record.get(1).toUpperCase())) {
                if (!name.toUpperCase().equals(record.get(0).toUpperCase())) {
                    counter += Integer.parseInt(record.get(2));
                } else {
                    break;
                }
            }
        }
        return counter;
    }
}
