package com.bridgelabz.service;

import com.bridgelabz.exception.CSVBuilderException;

import java.io.Reader;
import java.util.Iterator;

public class CSV_Interface {
    public <E> Iterator<E> getCSVfileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException {
        return null;
    }

}
