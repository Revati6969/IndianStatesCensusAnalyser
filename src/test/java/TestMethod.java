import com.bridgelabz.exception.CSVBuilderException;
import com.bridgelabz.model.CSVStatesCensus;
import com.bridgelabz.model.CSVStatesPojoClass;
import com.bridgelabz.service.StatesCensusAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestMethod {

    @Test
    public void givenNumberOfRecords_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
       try {
           StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesCensus.class);
           int numberOfRecords = stateCensusAnalyzer.loadRecords();
           Assert.assertEquals(29, numberOfRecords);
       }catch(CSVBuilderException e){
       }
    }

    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCensus.csv";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.txt";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus1.csv";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus2.csv";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv";
        try {
            StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesPojoClass.class);
            int numberOfRecords = stateCensusAnalyzer.loadRecords();
            Assert.assertEquals(37, numberOfRecords);
        }catch(CSVBuilderException e){
        }
    }

    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCode.csv";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesPojoClass.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.txt";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesPojoClass.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode1.csv";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesPojoClass.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode2.csv";
        StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH,CSVStatesPojoClass.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesCensus.class);
            stateCensusAnalyzer.loadRecords();
            String SortedData = stateCensusAnalyzer.SortedCensusData();
            CSVStatesCensus[] censusCSV = new Gson().fromJson(SortedData, CSVStatesCensus[].class);
            Assert.assertEquals("Andhra Pradesh", censusCSV[0].state);
        } catch (CSVBuilderException e){
    }
    }

    @Test
    public void givenStateCodeData_WhenSorted_ShouldReturnSortedList(){
        final String CSV_FILE_PATH = "src/test/resources/StateCode.csv";
        try {
            StatesCensusAnalyser stateCensusAnalyzer = new StatesCensusAnalyser(CSV_FILE_PATH, CSVStatesPojoClass.class);
            stateCensusAnalyzer.loadRecords();
            String SortedData = stateCensusAnalyzer.SortedStateCodeData();
            CSVStatesPojoClass[] StateCodes = new Gson().fromJson(SortedData, CSVStatesPojoClass[].class);
            Assert.assertEquals("AD", StateCodes[0].StateCode);
        }catch(CSVBuilderException e){
        }
    }
}

