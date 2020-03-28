package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {

    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "State", required = true)
    public static String state;

    @CsvBindByName(column = "Population", required = true)
    public int Population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int DensityPerSqKm;

}
