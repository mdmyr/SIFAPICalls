package com.siperianApi.putRequest;

import java.io.FileNotFoundException;

import com.siperian.sif.message.mrm.PutRequest;
import com.siperianApi.utilities.CSVFileReader;

public class PutRequestFactory {  
    public PutRequest getputRequest() throws IllegalStateException, FileNotFoundException {

        // read the csv file and create an object for the csv file.
        // set the RecordKey
        // set the Record
        // set the putRequest params and then return


         //Step1 
         CSVFileReader csvFilereader = new CSVFileReader();
         csvFilereader.genFileReaderOBJ(); // object of type of the file should be in list.
         
         


        return new PutRequest();
	}
}
