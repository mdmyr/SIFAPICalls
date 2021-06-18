package com.siperianApi.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;


import com.opencsv.bean.CsvToBeanBuilder;

public class CSVFileReader  {
        //create the using csvopenapi
        // step1: create the object as inputformat
        // parse the files using the inputformat.

// This is the main file reader app that sends the objects to put request
       public List<EnconomiclkpBinding> genFileReaderOBJ() throws IllegalStateException, FileNotFoundException{

        String fileName = "InputFiles/EnconomicInd_Lkp_2.csv";
        List<EnconomiclkpBinding> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(EnconomiclkpBinding.class)
                .withSeparator('|') // important
                .build()
                .parse();

        for (EnconomiclkpBinding enconomiclkpBinding : beans) {
                enconomiclkpBinding.getCode();
                System.out.println(enconomiclkpBinding.getCode()+ " and " + enconomiclkpBinding.getDescription() + " and " + enconomiclkpBinding.getCategory() + " and " + enconomiclkpBinding.getEcnomic_ind_cd() );

        }
        return beans;
}
        
}
