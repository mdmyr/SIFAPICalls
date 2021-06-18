package com.siperianApi.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import com.siperian.sif.client.SiperianClient;
import com.siperian.sif.message.mrm.PutRequest;
import com.siperianApi.putRequest.PutRequestFactory;

/**
 * 
 * @author yraghunp
 * Parameter executor
 */
public class PutRequestMain {

	
	/** 
	 * @param args
	 * @throws IllegalStateException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IllegalStateException, FileNotFoundException {
		System.out.println("Starting the put process.....");
		
		/** putRequest */
		//	PutRequest putRequest =createPutRequest();

		/** Create the Siperian client */
		//SiperianClient sipClient= createSiperianClient();
		//sipClient.process(putRequest);
		
		executePutList(); // actual execution of the put requests

}

	
	/** 
	 * @throws IllegalStateException
	 * @throws FileNotFoundException
	 */
	private static void executePutList() throws IllegalStateException, FileNotFoundException {
		PutRequestFactory putRequestFactory = new PutRequestFactory();
		List<PutRequest> putRequestList= putRequestFactory.getputRequest();
		processPutRequest(putRequestList);

	
	}

	
	/** 
	 * @param putRequestList
	 */
	private static void processPutRequest(List<PutRequest> putRequestList) {

		for (PutRequest putRequest : putRequestList) {
			SiperianClient sipClient =createSiperianClient();
			sipClient.process(putRequest);
			System.out.println("Put Process Completed!!");
		}
	}

	
	/** 
	 * @return SiperianClient
	 */
	private static SiperianClient createSiperianClient() {
		//retuns the sifClient 
		// set the properties here!
		File configProperties = new File("properties/cmxserver.properties");	
		SiperianClient sifClient = SiperianClient.newSiperianClient(configProperties);
		return sifClient;
	}

	/* Test purpose only!! **
	//creates a putRequest
	private static PutRequest createPutRequest() {
		PutRequest putRequest = new PutRequest();
		boolean generateSourceKey=true;
		putRequest.setGenerateSourceKey(generateSourceKey);

		RecordKey recordKey = getRecordKey();
		putRequest.setRecordKey(recordKey); // sets the record to the put request

		//Record record = getRecord();
		//putRequest.setRecord(record); //sets the record to the put request
		
		//PutRequest putRequest2PutRequest = new PutRequestFactory().getputRequest();

		return putRequest;
	}

	
	/** for testing purpse only  

	//create the Record
	private static Record getRecord() {
	 Record record = new Record();
	 record.setSiperianObjectUid("BASE_OBJECT.C_B_TEST_BO"); // BASE
	 record.setField(new Field("TEST_COL2", "TEST_COL5"));

	 return record;

	}

	//create the RecordKEY
	private static RecordKey getRecordKey() {
		RecordKey recordkey = new RecordKey();
		recordkey.setSourceKey("500");
		recordkey.setSystemName("Admin");
		return recordkey;
	}
	*/
}
