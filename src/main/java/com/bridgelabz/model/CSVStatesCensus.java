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

}
