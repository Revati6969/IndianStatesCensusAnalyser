package com.bridgelabz.dto;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {

    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "State", required = true)
    public static String state;

    @CsvBindByName(column = "Population", required = true)
    public long Population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public long AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public long DensityPerSqkm;

    public CSVStatesCensus(String state, long population, long areaInSqKm, long densityPerSqkm) {
        state = state;
        Population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqkm = densityPerSqkm;
    }

    public CSVStatesCensus() {
    }

    @Override
    public String toString() {
        return "CSVStatesCensus{" +
                "Population=" + Population +
                ", AreaInSqKm=" + AreaInSqKm +
                ", DensityPerSqkm=" + DensityPerSqkm +
                '}';
    }
}
