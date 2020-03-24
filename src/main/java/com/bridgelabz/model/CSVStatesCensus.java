package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {

    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public String population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public String AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public String DensityPerSqKm;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }

    public CSVStatesCensus(String state, String population, String areaInSqKm, String densityPerSqKm) {
        this.state = state;
        this.population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqKm = densityPerSqKm;
    }
}
