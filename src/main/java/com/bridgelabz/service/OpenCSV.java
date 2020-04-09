package com.bridgelabz.service;
import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSV implements CSV_Interface {
    //    ITERATOR OF CSV FILE
    @Override
    public <E> Iterator<E> getIterator(Reader reader, Class<E> csvClass) throws StatesCensusAnalyserException {
        try {
            return this.getCSVToBeen(reader, csvClass).iterator();
        }catch (StatesCensusAnalyserException e){
            e.printStackTrace();
        }
        return null;
    }

    // Return csvtoBean
    private  <E> CsvToBean<E> getCSVToBeen(Reader reader, Class<E> csvClass) throws StatesCensusAnalyserException {
        try {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            return csvToBeanBuilder.build();
        }  catch (IllegalStateException e) {
            throw new StatesCensusAnalyserException("Wrong file", StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }
    }
}
