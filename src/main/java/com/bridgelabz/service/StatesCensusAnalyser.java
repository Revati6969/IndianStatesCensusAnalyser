package com.bridgelabz.service;

import com.bridgelabz.exception.CSVBuilderException;
import com.bridgelabz.model.CSVStatesCensus;
import com.bridgelabz.model.CSVStatesPojoClass;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class StatesCensusAnalyser {

    OpenCSV openCSV = new OpenCSV();

    public Integer readFile(String filePath) throws Exception{
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))
        ) {
            List<CSVStatesCensus> listCSVfile = (List<CSVStatesCensus>) openCSV.CSVfileIterator(reader,CSVStatesCensus.class);
            return listCSVfile.size();

        } catch (NoSuchFileException e) {
            throw new CSVBuilderException("Enter a right file name and type", CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException("Check delimiter and header", CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (null);
    }

    // Read state code csv file
    public Integer loadIndianStateCodeData(String csvFilePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))
        ) {
            List<CSVStatesCensus> listCSVfile = (List<CSVStatesCensus>) openCSV.CSVfileIterator(reader,CSVStatesPojoClass.class);
            return listCSVfile.size();
        } catch (NoSuchFileException e) {
            throw new CSVBuilderException("Enter a right file name and type", CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException("Check delimiter and header", CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (null);
    }


    public String getStateWiseSortedData(String path) throws CSVBuilderException{
        try (Reader reader = Files.newBufferedReader(Paths.get(path))
        ) {
            List<CSVStatesCensus> listCSVfile = (List<CSVStatesCensus>) openCSV.CSVfileIterator(reader,CSVStatesCensus.class);
            Comparator<CSVStatesCensus> censusComparator = Comparator.comparing(Census -> Census.state);
            this.sort(listCSVfile, censusComparator);
            String sortedStateCensusjson = new Gson().toJson(listCSVfile);
            return sortedStateCensusjson;

        } catch (NoSuchFileException e) {
            throw new CSVBuilderException("Enter a right file name and type", CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException("Check delimiter and header", CSVBuilderException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sort(List<CSVStatesCensus> censusList, Comparator<CSVStatesCensus> censusComparator) {
        for (int i = 0; i < censusList.size()-1; i++){
            for(int j = 0; j < censusList.size()-i-1; j++){
                CSVStatesCensus census1 = censusList.get(j);
                CSVStatesCensus census2= censusList.get(j+1);
                if(censusComparator.compare(census1,census2) > 0){
                    censusList.set(j, census2);
                    censusList.set(j+1, census1);
                }
            }
        }
    }
}
