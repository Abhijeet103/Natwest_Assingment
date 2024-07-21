package com.natwest.Assingnment;

import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AssingnmentApplication {

	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(AssingnmentApplication.class, args);
		Service service  =  new Service();
		service.transform();

	}

}
