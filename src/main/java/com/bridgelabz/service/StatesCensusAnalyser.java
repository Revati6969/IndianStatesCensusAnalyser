package com.bridgelabz.service;

import com.bridgelabz.exception.CSVBuilderException;
import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.bridgelabz.model.CSVStatesCensus;
import com.bridgelabz.model.CSVStatesPojoClass;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StatesCensusAnalyser<E> {

    List<CensusDAO> list = null;
    Map<String, CensusDAO> map = null;

    public StatesCensusAnalyser() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    //    METHOD TO LOAD RECORDS OF CSV FILE
    public int loadRecords(String path) throws StatesCensusAnalyserException {
        int numberOfRecords = 0;
        String extension = path.substring(path.lastIndexOf(".") + 1);
        if (!extension.equals("csv")) {
            throw new StatesCensusAnalyserException("Incorrect file type", StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path))
        ) {
            OpenCSV csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<CSVStatesCensus> csvStatesCensusIterator = csvBuilder.getIterator(reader, CSVStatesCensus.class);
            while (csvStatesCensusIterator.hasNext()) {
                CensusDAO censusDAO = new CensusDAO(csvStatesCensusIterator.next());
                this.map.put(censusDAO.state, censusDAO);
                list = map.values().stream().collect(Collectors.toList());
            }
            numberOfRecords = map.size();
        } catch (NoSuchFileException e) {
            throw new StatesCensusAnalyserException("Give proper file name and path", StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new StatesCensusAnalyserException("Check delimiters and headers", StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return numberOfRecords;
    }

    //    METHOD TO LOAD RECORDS OF STATE CODE
    public int loadData(String path) throws StatesCensusAnalyserException {
        int numberOfRecords = 0;
        String extension = path.substring(path.lastIndexOf(".") + 1);
        if (!extension.equals("csv")) {
            throw new StatesCensusAnalyserException( "Incorrect file type",StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path))
        ) {
            OpenCSV csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<CSVStatesPojoClass> csvStatesPojoClassIterator = csvBuilder.getIterator(reader, CSVStatesPojoClass.class);
            while (csvStatesPojoClassIterator.hasNext()) {
                CSVStatesPojoClass csvStatesPojoClass = csvStatesPojoClassIterator.next();
                CensusDAO censusDTO = map.get(csvStatesPojoClass.StateName);
                if (censusDTO == null)
                    continue;
                censusDTO.stateCode = csvStatesPojoClass.StateCode;
            }
            numberOfRecords = map.size();
        } catch (NoSuchFileException e) {
            throw new StatesCensusAnalyserException("Give proper file name and path", StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new StatesCensusAnalyserException("Check delimiters and headers", StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return numberOfRecords;
    }

    public String SortedCensusData() throws StatesCensusAnalyserException {
        if (list == null || list.size() == 0) {
            throw new StatesCensusAnalyserException("No census data", StatesCensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<CensusDAO> comparator = Comparator.comparing(csvStatesCensus -> CSVStatesCensus.state);
        this.sortData(comparator);
        String sortedStateCensusJson = new Gson().toJson(list);
        return sortedStateCensusJson;
    }

    /*public String SortedStateCodeData() throws StatesCensusAnalyserException {
        if (csvStatesPojoClassList == null || csvStatesPojoClassList.size() == 0) {
            throw new StatesCensusAnalyserException("No census data", StatesCensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<CSVStatesPojoClass> comparator = Comparator.comparing(csvStatesPojoClass -> CSVStatesPojoClass.StateCode);
        this.sortData(comparator, csvStatesPojoClassList);
        String sortedStateCodeJson = new Gson().toJson(csvStatesPojoClassList);
        return sortedStateCodeJson;
    }*/

    private void sortData(Comparator<CensusDAO> csvComparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                CensusDAO census1 = list.get(j);
                CensusDAO census2 = list.get(j + 1);
                if (csvComparator.compare(census1, census2) > 0) {
                    list.set(j, census2);
                    list.set(j + 1, census1);
                }
            }
        }
    }


}
