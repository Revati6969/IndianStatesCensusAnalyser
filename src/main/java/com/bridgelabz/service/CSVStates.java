package com.bridgelabz.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVStates {
    public static String FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCode.csv";
    int count = 0;

    public static void main(String[] args) throws IOException, CsvValidationException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String[] nextRecord;
            while((nextRecord = csvReader.readNext()) != null){
                System.out.println("SrNo :" + nextRecord[0]);
                System.out.println("StateName :" + nextRecord[1]);
                System.out.println("StateCode :" + nextRecord[2]);
                System.out.println("TIN :" + nextRecord[3]);
                System.out.println("=========================");
            }
        }
    }

}
