package com.bridgelabz.service;
import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.bridgelabz.model.CSVStatesCensus;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

public class StatesCensusAnalyser {
    public static String CSV_FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCensusData.csv";
    int count = 0;

    public StatesCensusAnalyser(String path) {
        CSV_FILE_PATH = path;
    }


    public int loadData() throws IOException, StatesCensusAnalyserException {

       try (Reader reader = newBufferedReader(Paths.get(CSV_FILE_PATH));
       ) {
           CsvToBean<CSVStatesCensus> csvStateCensuses = new CsvToBeanBuilder(reader)
                   .withType(CSVStatesCensus.class)
                   .withIgnoreLeadingWhiteSpace(true)
                   .build();

           Iterator<CSVStatesCensus> csvStateCensusIterator = csvStateCensuses.iterator();
           while (csvStateCensusIterator.hasNext()) {
               CSVStatesCensus csvStateCensus = csvStateCensusIterator.next();
               System.out.println("State: " + csvStateCensus.getState());
               System.out.println("Area: " + csvStateCensus.getAreaInSqKm());
               System.out.println("Density: " + csvStateCensus.getDensityPerSqKm());
               System.out.println("Population: " + csvStateCensus.getPopulation());
               count++;
           }
       } catch (NoSuchFileException e) {
           throw new StatesCensusAnalyserException(StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);

       }
       return count;
    }

}
