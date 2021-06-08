package com.siperianApi.main;

import java.io.File;
import java.util.Properties;

import com.siperian.sif.client.SiperianClient;
import com.siperian.sif.message.Field;
import com.siperian.sif.message.Record;
import com.siperian.sif.message.RecordKey;
import com.siperian.sif.message.mrm.PutRequest;

/**
 * 
 * @author yraghunp
 * Parameter executor
 */
public class PutRequestMain {

	public static void main(String[] args) {
		System.out.println("Printer");
		
		/** putRequest */
		PutRequest putRequest =createPutRequest();

		/** Create the Siperian client */
		SiperianClient sipClient= createSiperianClient();
		sipClient.process(putRequest);

}

	private static SiperianClient createSiperianClient() {
		
		File configProperties = new File("properties/cmxserver.properties");
	
		SiperianClient sifClient = SiperianClient.newSiperianClient(configProperties);
		return sifClient;
	}

	//creats a putRequest
	private static PutRequest createPutRequest() {
		PutRequest putRequest = new PutRequest();
		boolean generateSourceKey=true;
		putRequest.setGenerateSourceKey(generateSourceKey);

		RecordKey recordKey = getRecordKey();
		putRequest.setRecordKey(recordKey); // sets the record to the put request

		Record record = getRecord();
		putRequest.setRecord(record); //sets the record to the put request

		return putRequest;
	}

	//create the Record
	private static Record getRecord() {
	 Record record = new Record();
	 record.setSiperianObjectUid("BASE_OBJECT.C_B_TEST"); // BASE
	 record.setField(new Field("TEST_COL1", "TEST_COL2"));

	 return record;

	}

	//create the RecordKEY
	private static RecordKey getRecordKey() {
		RecordKey recordkey = new RecordKey();
		recordkey.setSourceKey("100");
		recordkey.setSystemName("LOOKUP");
		return recordkey;
	}
}
