import com.bridgelabz.exception.CSVBuilderException;
import com.bridgelabz.exception.StatesCensusAnalyserException;
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
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCensus.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.txt";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus1.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus2.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv";
        try {
            int numberOfRecords = stateCensusAnalyzer.loadData(CSV_FILE_PATH);
            Assert.assertEquals(37, numberOfRecords);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/stateCode.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.txt";
       try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode1.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode2.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
            String sortedData = stateCensusAnalyzer.SortedStateCensusData();
            CSVStatesCensus[] censusCSV = new Gson().fromJson(sortedData, CSVStatesCensus[].class);
            Assert.assertEquals("Andhra Pradesh", censusCSV[0].state);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenStateCodeData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv";
        try {
            stateCensusAnalyzer.loadData(CSV_FILE_PATH);
            String SortedData = stateCensusAnalyzer.SortedStateCensusData();
            CSVStatesPojoClass[] stateCodes = new Gson().fromJson(SortedData, CSVStatesPojoClass[].class);
            Assert.assertEquals("AD", stateCodes[0].StateCode);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv";
        try {
            stateCensusAnalyzer.loadRecords(CSV_FILE_PATH);
            String sortedCensusData = stateCensusAnalyzer.getPopulationWiseSortedCensusData();
            CSVStatesCensus[] csvStatesCensus = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(199812341, csvStatesCensus[0].Population);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }
}

