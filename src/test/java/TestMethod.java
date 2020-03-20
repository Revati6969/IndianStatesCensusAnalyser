import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.bridgelabz.service.StatesCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class TestMethod {

    StatesCensusAnalyser censusAnalyser = new StatesCensusAnalyser();

    @Test
    public void givenStateCensusAnalyserFile_WhenTrue_NumberOfRecordShouldMatch() throws StatesCensusAnalyserException {
        Integer record = censusAnalyser.readFile("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.csv");
        Assert.assertEquals((Integer) 29, record);
    }

    @Test
    public void givenStateCode_WhenTrue_NumberOfRecordShouldMatch() throws StatesCensusAnalyserException {
        Integer result = censusAnalyser.loadIndianStateCodeData("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.csv");
        Assert.assertEquals((Integer) 37, result);
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenImproperFileName_ReturnsException() {
        try {
            censusAnalyser.readFile("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resource/StateCensus.csv");
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenImproperFileExtension_ReturnsException() {
       try {
           censusAnalyser.readFile("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus.txt");
       } catch (StatesCensusAnalyserException e) {
           Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
       }
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenIncorrectDelimiters_ReturnsException() {
          try {
              censusAnalyser.readFile("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus1.csv");
          } catch (StatesCensusAnalyserException e) {
              Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
          }
    }

    @Test
    public void givenStateCensusAnalyserFile_WhenIncorrectHeader_ReturnsException() {
        try {
            censusAnalyser.readFile("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCensus2.csv");
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }


    @Test
    public void givenStateCode_WhenImproperFileName_ReturnException() {
        try {
            censusAnalyser.loadIndianStateCodeData("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resource/StateCode.csv");
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenStateCode_WhenImproperFileType_ReturnException() {
        try {
            censusAnalyser.loadIndianStateCodeData("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode.txt");
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    @Test
    public void givenStateCode_WhenImproperDelimiter_ReturnException() {
        try {
            censusAnalyser.loadIndianStateCodeData("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode1.csv");
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }

    @Test
    public void givenStateCode_WhenImproperHeader_ReturnException() {

        try {
            censusAnalyser.loadIndianStateCodeData("/home/revatitekale/Desktop/CSVClone/IndianStatesCensusAnalyser/src/test/resources/StateCode2.csv");
        } catch (StatesCensusAnalyserException e) {
            Assert.assertEquals(StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT, e.exceptionType);
        }
    }
}

