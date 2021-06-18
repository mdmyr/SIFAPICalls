package com.siperianApi.deleteRequest;

import java.util.List;

import com.siperian.sif.message.RecordKey;
import com.siperian.sif.message.mrm.DeleteRequest;

/**
 * Simple Factory which enforces to ge delete request
 */
public class DeleteRequestFactory {
    
    // read file 
    // create delete object out it.

   
    private List recordKeys = setrecordKeys();

    public DeleteRequest createDeleteRequest() {
// ssrs
        DeleteRequest deleteRequest = new DeleteRequest();
        String siperianObjectUid="BASE_OBJECT.C_B_TEST_BO";
        deleteRequest.setSiperianObjectUid(siperianObjectUid);
        deleteRequest.setRecordKeys(recordKeys);
        return deleteRequest;
    }



    private List setrecordKeys() {
        RecordKey recordKey = new RecordKey();
        recordKey.setRowid("3");
        return recordKeys;
    }
}
