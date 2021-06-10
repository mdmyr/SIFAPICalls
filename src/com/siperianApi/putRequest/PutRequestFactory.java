package com.siperianApi.putRequest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.siperian.sif.message.Field;
import com.siperian.sif.message.Record;
import com.siperian.sif.message.RecordKey;
import com.siperian.sif.message.mrm.PutRequest;
import com.siperianApi.utilities.CSVFileReader;
import com.siperianApi.utilities.EnconomiclkpBinding;

public class PutRequestFactory {  
    private List<EnconomiclkpBinding> fileDetails;

    public List<PutRequest> getputRequest() throws IllegalStateException, FileNotFoundException {
        // single purpose per class is a good practice.
        // read the csv file and create an object for the csv file.
        // set the RecordKey
        // set the Record
        // set the putRequest params and then return


         //Step1 
         CSVFileReader csvFilereader = new CSVFileReader();
        // csvFilereader.genFileReaderOBJ(); // list <filetypeobject> of type of the file should be in list.
         fileDetails = csvFilereader.genFileReaderOBJ();  // inbound from the file in object  format

         //step 2 
         //return the Arryalist of put request
         
        return generatePutRequest(fileDetails);
	}

    // this method will create the put request from the inbound 
	private List<PutRequest> generatePutRequest(List<EnconomiclkpBinding> fileDetails2) {
        // required 
        // RecordKey : sourcekey
        // Record

        List<PutRequest> putRequestList = new ArrayList<>(); // better performance for storing but not for manupulating.
            // for each element in the file details make a put request
            for (EnconomiclkpBinding filedetails : fileDetails2) {
                
                PutRequest request= new PutRequest();
                RecordKey recordKey = new RecordKey(); //setting the RecordKey
                recordKey.setSourceKey( filedetails.getCategory() +"|"+filedetails.getCode()); //set the key
                recordKey.setSystemName("Lookup");
                
                Record record = new Record();// set the field values
                record.setSiperianObjectUid("BASE_OBJECT.C_B_LU_ECONOMIC_IND"); //** enhancement take it from the source file.
                
               
                //add the validation on the fields
                record.setField(new Field("ECONOMIC_IND_CATEGORY_CD", filedetails.getCode()));
                record.setField(new Field("ECONOMIC_IND_CATEGORY",filedetails.getCategory()));
                record.setField(new Field("DESCR", filedetails.getDescription()));
                record.setField(new Field("ECONOMIC_IND_CD", filedetails.getEcnomic_ind_cd()));


                System.out.println("++++++++++printing the field values ");
               System.out.println( record.getField("ECONOMIC_IND_CATEGORY_CD").getStringValue().length() +" and " +
                record.getField("ECONOMIC_IND_CATEGORY").getStringValue().length()+" and " +
                record.getField("DESCR").getStringValue().length()+" and " +
                record.getField("ECONOMIC_IND_CD").getStringValue().length());

                System.out.println("++++++++++end of printing the field values ");

               //Prepare the putrequest
				request.setGenerateSourceKey(true);
                request.setRecordKey(recordKey);
                request.setRecord(record);
            
                // add to the putRequestLIST
                putRequestList.add(request);
                
            }
            return putRequestList;
	}
}
