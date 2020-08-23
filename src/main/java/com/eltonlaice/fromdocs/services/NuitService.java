package com.eltonlaice.fromdocs.services;

import java.time.LocalDate;
import java.util.ArrayList;
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

	public LocalDate getBirthdate() { 
		ArrayList<String> dates = new ArrayList<String>(); 
		for (int i = 0; i < this.data_array_lines.length; i++) {
			String pattern = "[0-9]{2}(—|-)[0-9]{2}(—|-)[0-9]{4}";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(this.data_array_lines[i]);
			while (m.find()) {
				dates.add(m.group());
			}	
		}
		if (dates.size() > 0) {
			String [] date_array = dates.get(0).split("(—|-)");
			LocalDate birthdate = LocalDate.of(
					Integer.parseInt(date_array[2]), 
					Integer.parseInt(date_array[1]), 
					Integer.parseInt(date_array[0]));
			return birthdate;
		}
		return null;
	}

	public LocalDate getDateIssue() {
		ArrayList<String> dates = new ArrayList<String>(); 
		for (int i = 0; i < this.data_array_lines.length; i++) {
			String pattern = "[0-9]{2}(—|-)[0-9]{2}(—|-)[0-9]{4}";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(this.data_array_lines[i]);
			while (m.find()) {
				dates.add(m.group());
			}	
		}
		if (dates.size() > 1) {
			String [] date_array = dates.get(1).split("(—|-)");
			LocalDate dateIssue = LocalDate.of(
					Integer.parseInt(date_array[2]), 
					Integer.parseInt(date_array[1]), 
					Integer.parseInt(date_array[0]));
			return dateIssue;
		}
		return null;
	}
}
