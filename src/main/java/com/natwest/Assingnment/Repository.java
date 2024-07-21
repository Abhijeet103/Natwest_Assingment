package com.natwest.Assingnment;

import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.iterators.ArrayIterator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Data
@org.springframework.stereotype.Repository
public class Repository {

    Map<String  , List<String>> input ;
    Map<String  , String> map ;

    public Repository() throws IOException, CsvException {
        String inputPath = "C:/Users/disco/Desktop/Projects/Assingnment/Assingnment/src/main/resources/input1 - Sheet1.csv";

        FileHandler handler  = new FileHandler();
        this.input  =  handler.readCsvFile(inputPath);

        List<String []> temp = handler.CSVHelper("C:/Users/disco/Desktop/Projects/Assingnment/Assingnment/src/main/resources/reference.csv - Sheet1.csv");
        this.map = temp.stream()
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> arr[1]
                ));

        System.out.println(map);
    }
}
