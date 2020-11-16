package global.citytech.duke;

import global.citytech.duke.csv.ExportCSV;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class ExportCSVTest {

    @Test
    public void readCSVTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exports_small");
        List<String> column = new ArrayList<>(){{
           add("Country");
           add("Value (dollars)");
        }};
        exportCSV.printColumn(column);
    }

    @Test
    public void countryInfoTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exports_small");
        exportCSV.countryInfo("Germany");
    }

    @Test
    public void listExportersTwoProductsTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exports_small");
        exportCSV.listExportersTwoProducts("gold","diamonds");
    }

    @Test
    public void numberOfExportersTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exports_small");
        int result = exportCSV.numberOfExporters("gold");
        assertEquals(result,3);
    }

    @Test
    public void bigExportersTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exports_small");
        exportCSV.bigExporters("$999,999,999");
    }

    @Test
    public void listExportersTwoProductsQuizTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exportdata");
        exportCSV.listExportersTwoProducts("cotton","flowers");
    }

    @Test
    public void numberOfExportersQuizTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exportdata");
        int result = exportCSV.numberOfExporters("cocoa");
        assertEquals(result,17);
    }

    @Test
    public void countryInfoQuizTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exportdata");
        exportCSV.countryInfo("Nauru");
    }

    @Test
    public void bigExportersQuizTesting() throws IOException {
        ExportCSV exportCSV = new ExportCSV("exports/exportdata");
        exportCSV.bigExporters("$999,999,999,999");
    }
}
