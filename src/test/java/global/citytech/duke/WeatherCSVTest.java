package global.citytech.duke;

import global.citytech.duke.csv.WeatherCSV;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WeatherCSVTest {
    private static final double DELTA = 1e-15;

    WeatherCSV weatherCSV = new WeatherCSV();

    @Test
    public void readFilesTesting() throws IOException {
        weatherCSV.coldestHourInFile(weatherCSV.readSingleFile("2014/weather-2014-01-08.csv"));
    }

    @Test
    public void fileWithColdestTemperatureTesting() throws IOException {
        weatherCSV.fileWithColdestTemperature(weatherCSV.readAllFiles("2013"));
    }

    @Test
    public void lowestHumidityInManyFilesTesting() throws IOException {
        weatherCSV.lowestHumidityInManyFiles(weatherCSV.readAllFiles("2013"));
    }

    @Test
    public void lowestHumidityInFileTesting() throws IOException {
        System.out.println(weatherCSV.lowestHumidityInFile(weatherCSV.readSingleFile("2014/weather-2014-07-22.csv")).get("DateUTC"));
    }

    @Test
    public void averageTemperatureInFileTesting() throws IOException {
        double result = weatherCSV.averageTemperatureInFile(weatherCSV.readSingleFile("2013/weather-2013-08-10.csv"));
        assertEquals(result,80.19642857142857,DELTA);
    }

    @Test
    public void averageTemperatureWithHighHumidityInFileTesting() throws IOException {
        double result = weatherCSV.averageTemperatureWithHighHumidityInFile(weatherCSV.readSingleFile("2013/weather" +
                "-2013-09-02.csv"), 80);
        assertEquals(result,72.59375,DELTA);
    }

    @Test
    public void averageTemperatureWithHighHumidityInFile2Testing() throws IOException {
        double result = weatherCSV.averageTemperatureWithHighHumidityInFile(weatherCSV.readSingleFile("2014/weather" +
                "-2014-03-20.csv"), 80);
        assertEquals(result,41.78666666666667,DELTA);
    }
}
