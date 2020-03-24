package com.bridgelabz.service;

import com.bridgelabz.exception.CSVBuilderException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSV implements CSV_Interface {
    //Return file in iterator
    public <E> Iterator<E> CSVfileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException {
        return this.getCSVToBeen(reader, csvClass).iterator();
    }
    //Return file in List
    @Override
    public <E> List<E> getCSVfileList(Reader reader, Class<E> csvClass) throws CSVBuilderException {
        return this.getCSVToBeen(reader, csvClass).parse();
    }
    //return csvToBean
    private <E> CsvToBean<E> getCSVToBeen(Reader reader, Class<E> csvClass) throws CSVBuilderException {
        try {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
            CsvToBean<E> csvToBean = csvToBeanBuilder.withType(csvClass).withIgnoreLeadingWhiteSpace(true).build();
            return csvToBean;
        } catch (RuntimeException e) {
            throw new CSVBuilderException("Check delimiters and header", CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (null);
    }
}
