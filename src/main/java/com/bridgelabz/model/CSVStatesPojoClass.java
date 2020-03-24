package com.bridgelabz.model;


import com.opencsv.bean.CsvBindByName;

public class CSVStatesPojoClass {
    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "SrNo", required = true)
    public String SrNo;

    @CsvBindByName(column = "StateName", required = true)
    public String StateName;

    @CsvBindByName(column = "StateCode", required = true)
    public String StateCode;

    @CsvBindByName(column = "TIN", required = true)
    public String TIN;

    public String getSrNo() {
        return SrNo;
    }

    public void setSrNo(String srNo) {
        SrNo = srNo;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public CSVStatesPojoClass(String srNo, String stateName, String stateCode, String TIN) {
        SrNo = srNo;
        StateName = stateName;
        StateCode = stateCode;
        this.TIN = TIN;
    }
}
