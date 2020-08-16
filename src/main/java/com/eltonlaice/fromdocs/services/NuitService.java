package com.eltonlaice.fromdocs.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

public class NuitService {
	private String data;
	private String [] data_array;
	private String [] data_array_lines;
	
	public NuitService(String data) {
		this.data = data;
		this.data_array = data.split("\\s+");
		this.data_array_lines = data.split("\\n+");
	}

	public String getNumber() {
		String number = null; 
		for (int i = 0; i < this.data_array.length; i++) {
			if(this.data_array[i].length() <= 10) {
				String pattern = "[0-9]{9}";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(this.data_array[i]);
				while (m.find()) {
					number = m.group();
					break;
				}	
			}
		}
		return number;
	}

	public String [] getFullName() {
		String [] fullNameArray = null;
		String fullName = null;
		for (int i = 0; i < data_array_lines.length; i++) {
			int result = data_array_lines[i].indexOf("Nome:");
			if(result != -1) {
				fullName = data_array_lines[i];
				break;
			}
		}
		if(!fullName.equals(null)) {
			fullNameArray = fullName.split("\\s+");
			fullNameArray = ArrayUtils.remove(fullNameArray, 0);
		}
		return fullNameArray;
	}

	public String getLastName() {
		String lastName = null;
		String [] fullNameArray = getFullName();
		if(!fullNameArray.equals(null))
			return fullNameArray[fullNameArray.length -1];
		return lastName;
	}

	public String getGivenNames() {
		String givenNames = "";
		String [] fullNameArray = getFullName();
		if(!fullNameArray.equals(null)) {
			for (int i = 0; i < fullNameArray.length -1; i++) {
				givenNames+=fullNameArray[i] + " ";
			}
		}
		return givenNames;
	}

}
