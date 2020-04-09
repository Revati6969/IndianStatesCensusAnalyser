package com.bridgelabz.service;

public class CSVBuilderFactory {
    public static CSV_Interface createCSVBuilder() {
        return new OpenCSV();
    }
}
