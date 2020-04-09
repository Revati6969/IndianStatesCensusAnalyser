import com.bridgelabz.dao.CensusDAO;
import com.bridgelabz.dto.CSVStatesCensus;
import com.bridgelabz.dto.CSVStatesPojoClass;
import com.bridgelabz.dto.CSVUSCensus;
import com.bridgelabz.exception.StatesCensusAnalyserException;
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
        final String CSV_FILE_PATH = "src/test/resources/StateCensus.csv";
        try {
            int numberOfRecords = indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            Assert.assertEquals(29, numberOfRecords);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/stateCensus.pdf";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensus1.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensus1.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() throws IOException {
        final String CSV_FILE_PATH = "src/test/resources/StateCode.csv";
        try {
            int numberOfRecords = indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            Assert.assertEquals(37, numberOfRecords);
        } catch (StatesCensusAnalyserException e) {
        }
    }

    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/stateCode.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/StateCode.pdf";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/StateCode1.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "src/test/resources/StateCode1.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.STATE);
            CSVStatesCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals("Andhra Pradesh", CSVStatesCensus.state);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test   //sort state code
    public void givenStateCodeData_WhenSorted_ShouldReturnSortedList() {
        final String CSV_FILE_PATH = "src/test/resources/StateCode.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.STATE);
            CSVStatesPojoClass[] StateCodes = new Gson().fromJson(sortedCensusData, CSVStatesPojoClass[].class);
            Assert.assertEquals("AD", CSVStatesPojoClass.StateCode);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensus.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.POPULATION);
            CSVStatesCensus[] csvStatesCensus = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(199812341, csvStatesCensus[0].Population);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnDensityPerSqKm_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensusData.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.DENSITY);
            CSVStatesCensus[] csvStateCensuses = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(1102, csvStateCensuses[0].DensityPerSqkm);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenTheStateCensusData_WhenSortedOnAreaInPerSqKm_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "src/test/resources/StateCensusData.csv";
        try {
            indianCensusAnalyzer.loadStateCensusCSVData(INDIA, CSV_FILE_PATH);
            String sortedCensusData = indianCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.AREA);
            CSVStatesCensus[] csvStateCensuses = new Gson().fromJson(sortedCensusData, CSVStatesCensus[].class);
            Assert.assertEquals(342239, csvStateCensuses[0].AreaInSqKm);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void givenUSCensusAnalyserFile_WhenTrue_NumberOfRecordShouldMatch() throws IOException {
        final String CSV_FILE_PATH = "src/test/resources/USCensusData.csv";
        int count = 0;
        try {
            count = usCensusAnalyzer.loadStateCensusCSVData(US, CSV_FILE_PATH);
            Assert.assertEquals(51, count);
        } catch (StatesCensusAnalyserException e) {
        }
    }

    @Test
    public void givenTheUSCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "src/test/resources/USCensusData.csv";
        try {
            usCensusAnalyzer.loadStateCensusCSVData(CensusAnalyser.Country.US, CSV_FILE_PATH);
            String sortedCensusData = usCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.POPULATION);
            CensusDAO[] censusDAOS = new Gson().fromJson(sortedCensusData, CensusDAO[].class);
            Assert.assertEquals("California", censusDAOS[0].State);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTheUSCensusData_WhenSortedOnPopulationDensity_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "src/test/resources/USCensusData.csv";
        try {
            usCensusAnalyzer.loadStateCensusCSVData(US, CSV_FILE_PATH);
            String sortedCensusData = usCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.DENSITY);
            CSVUSCensus[] csvUsCensus = new Gson().fromJson(sortedCensusData, CSVUSCensus[].class);
            Assert.assertEquals(3805, csvUsCensus[0].PopulationDensity);
        } catch (StatesCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTheUSCensusData_WhenSortedOnArea_ShouldReturnSortedResult() {
        final String CSV_FILE_PATH = "src/test/resources/USCensusData.csv";
        try {
            usCensusAnalyzer.loadStateCensusCSVData(US, CSV_FILE_PATH);
            String sortedCensusData = usCensusAnalyzer.SortedStateCensusData(CensusAnalyser.SortingMode.AREA);
            CSVUSCensus[] csvusCensus = new Gson().fromJson(sortedCensusData, CSVUSCensus[].class);
            Assert.assertEquals(1723338, csvusCensus[0].Area);
        } catch (StatesCensusAnalyserException e) {
            e.getStackTrace();
        }
    }
}

