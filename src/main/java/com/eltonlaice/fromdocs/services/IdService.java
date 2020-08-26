package com.eltonlaice.fromdocs.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

public class IdService {
	private String data;
	private String [] data_array;
	private String [] data_array_lines;
	
	public IdService(String data) {
		this.data = data;
		this.data_array = data.split("\\s+");
		this.data_array_lines = data.split("\\n+");
	}

	public String getNumber() {
		String [] data_id_array;
		String number_part_a = "", 
				number_part_b = "";
		if(fullIdString().length > 3) {
			data_id_array = fullIdString();
			
			String pattern_part_a = "[0-9]+";
			Pattern r = Pattern.compile(pattern_part_a);
			Matcher m = r.matcher(data_id_array[0]);
			if (m.find()) {
				number_part_b = m.group();
			}
			
			String pattern_part_b = "[0-9]{8}[A-Z]";
			Pattern rb = Pattern.compile(pattern_part_b);
			Matcher mb = rb.matcher(data_id_array[2]);
			if (mb.find()) {
				number_part_a = mb.group();
			}
			
			char last_chart_id = number_part_a.charAt(8);
			number_part_a = number_part_a.substring(0, 4);
			
			return number_part_a + number_part_b + last_chart_id;
		}
		return null;
	}

	public String getLastName() {
		String [] data_id_array = fullIdString();
		if (data_id_array.length > 3) {
			return data_id_array[3].substring(1);
		}
		return null;
	}

	public String getGivenNames() {
		String GivenNames = "";
		String [] data_id_array = fullIdString();
		if (data_id_array.length > 3) {
			for (int i = 4; i < data_id_array.length; i++) {
				if (i != data_id_array.length - 1) {
					GivenNames+= data_id_array[i] + " ";
				}else {
					GivenNames+= data_id_array[i];
				}				
			}
			return GivenNames;
		}
		return null;
	}

	public LocalDate getBirthdate() { 
		String [] data_id_array = fullIdString();
		if (data_id_array.length > 2) {
			String data = data_id_array[2];
			LocalDate birthdate = LocalDate.of(
					formatMonthOfYear(Integer.parseInt(data.substring(0, 2))), 
					Integer.parseInt(data.substring(3, 4)), 
					Integer.parseInt(data.substring(5, 6)));
			return birthdate;
		}
		return null;
	}

	public String [] fullIdString() {
		int lineStartIndex = 0; 
		for (int i = 0; i < this.data_array_lines.length; i++) {
			String pattern = "BIMOZ";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(this.data_array_lines[i]);
			while (m.find()) {
				lineStartIndex = i;
				break;
			}	
		}
		String fullIdString = data_array_lines[lineStartIndex] + 
							  data_array_lines[lineStartIndex + 1] +
							  data_array_lines[lineStartIndex + 2];
		fullIdString = fullIdString.toUpperCase();
		return fullIdString.split("<+");
	}
	
	public int formatMonthOfYear(int year) {
		return year > 20? year + 1900: year + 2000; 
	}
}
