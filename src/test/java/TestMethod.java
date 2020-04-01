import com.bridgelabz.dao.CensusDAO;
import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.bridgelabz.dto.CSVStatesCensus;
import com.bridgelabz.service.CensusAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.bridgelabz.service.CensusAnalyser.Country.INDIA;
import static com.bridgelabz.service.CensusAnalyser.Country.US;

public class TestMethod {

    CensusAnalyser indianCensusAnalyzer = new CensusAnalyser(INDIA);
    CensusAnalyser usCensusAnalyzer = new CensusAnalyser(US);

    @Test
    public void givenNumberOfRecords_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            int numberOfRecords = indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            Assert.assertEquals(29, numberOfRecords);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.txt";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus1.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus2.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv";
        try {
            int numberOfRecords = indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            Assert.assertEquals(37, numberOfRecords);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCode.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.txt";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode1.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode2.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.STATE);
            CSVStatesCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals("Andhra Pradesh", CSVStatesCensus.state);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.POPULATION);
            CSVStatesCensus[] csvStatesCensus = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(199812341, csvStatesCensus[0].Population);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnDensityPerSqKm_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.DENSITY);
            CSVStatesCensus[] csvStateCensuses = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(1102, csvStateCensuses[0].DensityPerSqkm);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnAreaInPerSqKm_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/main/java/com/bridgelabz/model/CSVStatesCensus.java";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.AREA);
            CSVStatesCensus[] csvStateCensuses = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(342239, csvStateCensuses[0].AreaInSqKm);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenUSCensusAnalyserFile_WhenTrue_NumberOfRecordShouldMatch() throws StatesCensusAnalyserException {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/USCensusData.csv";
        int count = usCensusAnalyzer.loadStateCensusCSVData(US, CSV_FILE_PATH);
        Assert.assertEquals(51, count);
    }

    @Test
    public void givenTheUSCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/USCensusData.csv";
        try {
            int numberOfRecords = usCensusAnalyzer.loadStateCensusCSVData(CensusAnalyser.Country.US, CSV_FILE_PATH);
            String sortedCensusData = usCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.POPULATION);
            CensusDAO[] censusDAOS = new Gson().fromJson(sortedCensusData, CensusDAO[].class);
            Assert.assertEquals("California",censusDAOS[0].State);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTheUSCensusData_WhenSortedOnPopulationDensity_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/USCensusData.csv";
        try {
            int numberOfRecords = usCensusAnalyzer.loadStateCensusCSVData(CensusAnalyser.Country.US, CSV_FILE_PATH);
            String sortedCensusData = usCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.DENSITY);
            CensusDAO[] censusDAOS = new Gson().fromJson(sortedCensusData, CensusDAO[].class);
            Assert.assertEquals("District of Columbia",censusDAOS[0].State);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTheUSCensusData_WhenSortedOnArea_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/USCensusData.csv";
        try {
            int numberOfRecords = usCensusAnalyzer.loadStateCensusCSVData(CensusAnalyser.Country.US, CSV_FILE_PATH);
            String sortedCensusData = usCensusAnalyzer.SortedCensusData(CensusAnalyser.SortingMode.AREA);
            CensusDAO[] censusDAOS = new Gson().fromJson(sortedCensusData, CensusDAO[].class);
            Assert.assertEquals("Alaska",censusDAOS[0].State);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }






}

