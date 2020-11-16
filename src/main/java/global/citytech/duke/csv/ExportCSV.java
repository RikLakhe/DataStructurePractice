package global.citytech.duke.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

public class ExportCSV {
    private CSVParser records;
    private ArrayList<ArrayList<String>> arrayListRecords;

    public ExportCSV() {
    }

    public ExportCSV(String fileName) throws IOException {
        readCSVFile(fileName);
        setArrayListRecords();
    }

    public void readCSVFile(String fileName) throws IOException {
        File file = new File("src/main/resources/csvFiles/" + fileName + ".csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        this.records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
    }

    public void printColumn(List<String> columnNames) {
        ArrayList<ArrayList<String>> arrayRows = new ArrayList<>();
        for (CSVRecord record : records) {
            ArrayList<String> arrayRow = new ArrayList<>();
            for (String columnName : columnNames) {
                arrayRow.add(record.get(columnName));
            }
            arrayRows.add(arrayRow);
        }

        for (ArrayList<String> row : arrayRows) {
            for (String data : row) {
                System.out.print(data + " ");
            }
            System.out.print("\n");
        }
    }

    public void printColumn() {
        List<String> headers = records.getHeaderNames();
        printColumn(headers);
    }

    public void setArrayListRecords() {
        List<String> headers = records.getHeaderNames();
        ArrayList<ArrayList<String>> arrayRows = new ArrayList<>();
        for (CSVRecord record : records) {
            ArrayList<String> arrayRow = new ArrayList<>();
            for (String columnName : headers) {
                arrayRow.add(record.get(columnName));
            }
            arrayRows.add(arrayRow);
        }

        this.arrayListRecords = arrayRows;
    }

    public void countryInfo(String country) {
        boolean found = false;
        for (ArrayList<String> rowData : arrayListRecords) {
            if (rowData.get(0).toLowerCase().equals(country.toLowerCase())) {
                found = true;
                for (String data : rowData) {
                    System.out.print(data + ":");
                }
            }
        }
        if(!found){
            System.out.println("NOT FOUND");
        }
    }

    public void listExportersTwoProducts(String exportItem1,String exportItem2){
        boolean found = false;
        for (ArrayList<String> rowData : arrayListRecords) {
            if (rowData.get(1).toLowerCase().contains(exportItem1.toLowerCase()) && rowData.get(1).toLowerCase().contains(exportItem2.toLowerCase())) {
                found = true;
                    System.out.println(rowData.get(0));
            }
        }
        if(!found){
            System.out.println("NOT FOUND");
        }
    }

    public int numberOfExporters(String exportItem){
        int count=0;
        for (ArrayList<String> rowData : arrayListRecords) {
            if (rowData.get(1).toLowerCase().contains(exportItem.toLowerCase())) {
                count++;
            }
        }

        return count;
    }

    public void bigExporters(String limitValue){
        boolean found = false;
        for (ArrayList<String> rowData : arrayListRecords) {
            if (rowData.get(2).length() > limitValue.length()) {
                found = true;
                System.out.println(rowData.get(0) + " " + rowData.get(2));
            }
        }
        if(!found){
            System.out.println("NOT FOUND");
        }
    }
}
