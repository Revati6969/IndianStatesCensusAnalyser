package com.bridgelabz.service;

import com.bridgelabz.adapter.CensusAdapterFactory;
import com.bridgelabz.dao.CensusDAO;
import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CensusAnalyser<E> {

    List<CensusDAO> censusList = null;
    Map<String, CensusDAO> censusDAOMap = null;
    private Country country;

    //CONSTRUCTOR
    public CensusAnalyser(Country country) {
        this.country = country;
    }

    //ENUM FOR Sorting MODE
    public enum SortingMode {STATE, POPULATION, DENSITY, AREA}

    //ENUM FOR COUNTRY
    public enum Country {INDIA, US}

    public int loadStateCensusCSVData(Country country, String... csvFilePath) throws StatesCensusAnalyserException {
        censusDAOMap = CensusAdapterFactory.getCensusData(country, csvFilePath);
        censusList = censusDAOMap.values().stream().collect(Collectors.toList());
        return censusDAOMap.size();
    }

    //METHOD TO SORT CENSUS DATA BY STATE
    public String SortedStateCensusData(SortingMode mode) throws StatesCensusAnalyserException {
        if (censusList == null || censusList.size() == 0) {
            throw new StatesCensusAnalyserException("No census data",StatesCensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        ArrayList arrayList = censusDAOMap.values().stream()
                .sorted(CensusDAO.getSortComparator(mode))
                .map(censusDAO -> censusDAO.getCensusDTO(country))
                .collect(Collectors.toCollection(ArrayList::new));
        return new Gson().toJson(arrayList);

    }
}
