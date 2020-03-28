package com.bridgelabz.service;

import com.bridgelabz.model.CSVStatesCensus;

public class CensusDAO {
    public String state;
    public int population;
    public int area;
    public int density;
    public String stateCode;

    public CensusDAO(CSVStatesCensus csvStatesCensus) {
        this.state = csvStatesCensus.state;
        this.population = csvStatesCensus.Population;
        this.area = csvStatesCensus. AreaInSqKm;
        this.density = csvStatesCensus. DensityPerSqKm;
    }
}
