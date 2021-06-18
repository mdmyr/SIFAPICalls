package com.siperianApi.deleteRequest;

import java.io.File;

import com.siperian.sif.client.SiperianClient;
import com.siperian.sif.message.SiperianRequest;

/**
 * - Actucal execution of delete call
 */
public class DeleteMain {
    
 private static File configProperties = getConfigPropeties();

    public static void main(String[] args) {
        
        // get the properties 
        // create a siprian client with the properties 
        // get the delet request
        // fire the delete the request and capture the response.
     SiperianClient siperianClient=  getSiperianClient(configProperties);
     SiperianRequest deleteRequest =new DeleteRequestFactory().createDeleteRequest();
     System.out.println("Recieved the delete request" + deleteRequest.toString());
    siperianClient.process(deleteRequest);   
    }

    private static File getConfigPropeties() {
        File file = new File("properties/cmxserver.properties");
        return file;
    }

    private static SiperianClient getSiperianClient(File configProperties) {
        SiperianClient siperianClient = SiperianClient.newSiperianClient(configProperties);
        return siperianClient;
    }
}
