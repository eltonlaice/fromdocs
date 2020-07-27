package com.eltonlaice.fromdocs;

public class Passport extends Document{
	/**
	 * Represent Type of Passport <br>
	 * Example: String type = "PN"
	 */
	private String type;
	
	/**
	 * Represent ID Number
	 */
	private String id_number;

	/**
	 * Represent nationality
	 */
	private String nationality;

	
	public Passport() {
		super();
	}

	public String getType() {
		return type;
	}

	public String getId_number() {
		return id_number;
	}

	public String getNationality() {
		return nationality;
	}
	
}
