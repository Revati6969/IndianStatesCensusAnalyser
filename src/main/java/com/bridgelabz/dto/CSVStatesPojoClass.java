package com.bridgelabz.dto;


import com.opencsv.bean.CsvBindByName;

public class CSVStatesPojoClass {

    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "SrNo", required = true)
    public int SrNo;

    @CsvBindByName(column = "StateName", required = true)
    public String StateName;

    @CsvBindByName(column = "StateCode", required = true)
    public static String StateCode;

    @CsvBindByName(column = "TIN", required = true)
    public int TIN;

    public CSVStatesPojoClass(int srNo, String stateName, String stateCode, int TIN) {
        SrNo = srNo;
        StateName = stateName;
        StateCode = stateCode;
        this.TIN = TIN;
    }

    public CSVStatesPojoClass() {
    }
}
