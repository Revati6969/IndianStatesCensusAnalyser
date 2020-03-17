import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.bridgelabz.service.StatesCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

import static com.bridgelabz.service.StatesCensusAnalyser.CSV_FILE_PATH;

public class TestMethod {
    @Test
    public void givenStateCensusAnalyserFile_WhenTrue_NumberOfRecordShouldMatch() throws StatesCensusAnalyserException {
        CSV_FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCensusData.csv";
        StatesCensusAnalyser censusAnalyser = new StatesCensusAnalyser( CSV_FILE_PATH);
        int count = censusAnalyser.loadData();
        Assert.assertEquals(29, count);
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenImproperFileName_ReturnsException()  {
        CSV_FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCensusData.csv";
        StatesCensusAnalyser censusAnalyser = new StatesCensusAnalyser(CSV_FILE_PATH);
        try {
            censusAnalyser.loadData();
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenImproperFileExtension_ReturnsException()  {
        CSV_FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/stateCensusData.txt";
        StatesCensusAnalyser censusAnalyser = new StatesCensusAnalyser(CSV_FILE_PATH);
        try {
            censusAnalyser.loadData();
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenIncorrectDelimiters_ReturnsException()  {
        CSV_FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCensusData1.csv";
        StatesCensusAnalyser censusAnalyser = new StatesCensusAnalyser(CSV_FILE_PATH);
        try {
            censusAnalyser.loadData();
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT,e.exceptionType);
        }
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenIncorrectHeader_ReturnsException()  {
        CSV_FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCensusData2.csv";
        StatesCensusAnalyser censusAnalyser = new StatesCensusAnalyser(CSV_FILE_PATH);
        try {
            censusAnalyser.loadData();
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT,e.exceptionType);
        }
    }
}
