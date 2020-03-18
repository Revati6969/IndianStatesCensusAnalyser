package com.bridgelabz.service;
import com.bridgelabz.model.CSVStatesPojoClass;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CSVStates {
    public static String FILE_PATH = "/home/admin1/Desktop/CSVProgram/src/test/resources/StateCode.csv";
    static int count = 0;

    public CSVStates(String Path) {
        FILE_PATH = Path;
    }

    public static int LoadCSVData() throws IOException{
        try (
                Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));

        ) {
            CsvToBean<CSVStatesPojoClass> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStatesPojoClass.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStatesPojoClass> csvStatesPojoClassIterator = csvToBean.iterator();
            while (csvStatesPojoClassIterator.hasNext()) {
                CSVStatesPojoClass csvStatesPojoClass = csvStatesPojoClassIterator.next();
                System.out.println("SrNo :" + csvStatesPojoClass.getSrNo());
                System.out.println("StateName :" + csvStatesPojoClass.getStateName());
                System.out.println("StateCode :" + csvStatesPojoClass.getStateCode());
                System.out.println("TIN :" + csvStatesPojoClass.getTIN());
                System.out.println("=========================");
                count++;

            }
            }
        return count;
        }
    }


