package com.bridgelabz.dto;

import com.opencsv.bean.CsvBindByName;

public class CSVUSCensus {
    @CsvBindByName(column = "State Id", required = true)
    public String StateID;

    @CsvBindByName(column = "State", required = true)
    public String State;

    @CsvBindByName(column = "Population Density", required = true)
    public long PopulationDensity;

    @CsvBindByName(column = "Population", required = true)
    public long Population;

    @CsvBindByName(column = "Total area", required = true)
    public long Area;

    @CsvBindByName(column = "Housing Density", required = true)
    public float HousingDensity;

    public CSVUSCensus(String stateId, String state, long population, long totalArea, long populationDensity) {
        this.StateID = stateId;
        this.State = state;
        this.Population = population;
        this.Area = totalArea;
        this.PopulationDensity = populationDensity;
    }
}
