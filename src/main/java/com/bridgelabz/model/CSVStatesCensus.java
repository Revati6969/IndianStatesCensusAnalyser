package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {
    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "State", required = true)
    private String state;

    @CsvBindByName(column = "Population", required = true)
    private String population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    private String AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private String DensityPerSqKm;

  }
