package com.bridgelabz.model;


import com.opencsv.bean.CsvBindByName;

public class CSVStatesPojoClass {
    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "SrNo" , required = true)
    private String SrNo;

    @CsvBindByName(column = "StateName" , required = true)
    private String StateName;

    @CsvBindByName(column = "StateCode" , required = true)
    private String StateCode;

    @CsvBindByName(column = "TIN" , required = true)
    private String TIN;


}
