package com.siperianApi.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class CSFFileReaderMain  {
    public static void main(String[] args) throws IOException {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
         CSVFileReader csvFileReader = new CSVFileReader();
         csvFileReader.genFileReaderOBJ();
  
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        String fileName = "C:\\Users\\yraghunp\\eclipse-workspace23\\SiperianPutCall\\InputFiles\\EnconomicInd_Lkp.csv";

        List<EnconomiclkpBinding> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(EnconomiclkpBinding.class)
                .withSeparator('|') // important
                .build()
                .parse();

        for (EnconomiclkpBinding enconomiclkpBinding : beans) {
                enconomiclkpBinding.getCode();
                System.out.println(enconomiclkpBinding.getCode()+ " and " + enconomiclkpBinding.getDescription() + " and " + enconomiclkpBinding.getCategory() );

        }

    }
}