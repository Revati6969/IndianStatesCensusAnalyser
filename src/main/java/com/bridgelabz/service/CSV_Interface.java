package com.bridgelabz.service;

import com.bridgelabz.exception.StatesCensusAnalyserException;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface CSV_Interface {
    <E> Iterator<E> getIterator(Reader reader, Class<E> csvClass) throws StatesCensusAnalyserException;

    <E> List<E> getList(Reader reader, Class<E> csvClass) throws StatesCensusAnalyserException;
}
