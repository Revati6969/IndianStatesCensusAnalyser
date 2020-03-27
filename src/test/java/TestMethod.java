import com.bridgelabz.exception.CSVBuilderException;
import com.bridgelabz.model.CSVStatesCensus;
import com.bridgelabz.model.CSVStatesPojoClass;
import com.bridgelabz.service.StatesCensusAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TestMethod {

    StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser();

    @Test
    public void givenNumberOfRecords_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            int numberOfRecords = stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
            Assert.assertEquals(29, numberOfRecords);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCensus.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.txt";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus1.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus2.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv";
        try {
            int numberOfRecords = stateCensusAnalyzer.loadData(CSV_FILE_PATH);
            Assert.assertEquals(37, numberOfRecords);
        } catch (CSVBuilderException e) {
        }
    }

    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCode.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.txt";
       try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode1.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode2.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
            String SortedData = stateCensusAnalyzer.SortedCensusData();
            CSVStatesCensus[] censusCSV = new Gson().fromJson(SortedData, CSVStatesCensus[].class);
            Assert.assertEquals("Andhra Pradesh", CSVStatesCensus.state);
        } catch (CSVBuilderException e) {
        }
    }

    @Test
    public void givenStateCodeData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
            String SortedData = stateCensusAnalyzer.SortedStateCodeData();
            CSVStatesPojoClass[] StateCodes = new Gson().fromJson(SortedData, CSVStatesPojoClass[].class);
            Assert.assertEquals("AD", CSVStatesPojoClass.StateCode);
        } catch (CSVBuilderException e) {
        }
    }
}

