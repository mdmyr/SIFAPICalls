package com.siperianApi.utilities;
/**
 * This class will create a binding to read and create the EconomicIND Lkp object
 *  this is by positions ... be careful
 */

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class EnconomiclkpBinding {
    @CsvBindByPosition(position = 0)
    private String Code;
    @CsvBindByPosition(position = 1)
    private String Description;
    @CsvBindByPosition(position = 2)
    private String Category;


	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}


	

}