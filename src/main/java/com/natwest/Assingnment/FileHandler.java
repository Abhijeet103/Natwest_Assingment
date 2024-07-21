package com.natwest.Assingnment;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileHandler {

        String filePath ;
    public List<String []> CSVHelper(String path ) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(path));
        return reader.readAll();
    }
    public Map<String , List<String>> readCsvFile(String path) throws IOException, CsvException {
        List<String[]> lines = CSVHelper(path);
        if (lines.isEmpty()) {
            System.out.println("CSV file is empty");
        }

        // The first line is the header
        String[] header = lines.get(0);

        // Initialize the HashMap
        Map<String, List<String>> columnData = new HashMap<>();

        // Initialize the lists for each column
        for (String columnName : header) {
            columnData.put(columnName, new ArrayList<>());
        }

        // Populate the lists with column data
        for (int i = 1; i < lines.size(); i++) {
            String[] row = lines.get(i);
            for (int j = 0; j < header.length; j++) {
                columnData.get(header[j]).add(row[j]);
            }
        }

        return columnData ;

    }
}
