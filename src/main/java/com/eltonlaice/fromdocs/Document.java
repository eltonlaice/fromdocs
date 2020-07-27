package com.eltonlaice.fromdocs;

import java.time.LocalDate;

/**
 * The main class to representation of any personal identification document. 
 * 
 * @author Elton Tomás Laice
 * 
 */
public class Document {
	/**
	 * Country of origin of the documen
	 * example: "MZ" for Mozambique
	 */
	protected String country;
	
	/**
	 * Unique document identification number.
	 * 
	 */
	protected String number;
	
	/**
	 * All names before the Surname. <br>
	 * For example, if the full name is: <b>Elton Tomas</b> Laice <br>
	 * String givenNames = "Elton Tomas"
	 */
	protected String givenNames;
	
	/**
	 * Surname. <br>
	 * For example, if the full name is: Elton Tomas Laice <br>
	 * String lastName = "Laice"
	 */
	protected String lastName;
	
	/**
	 * Date of birth
	 * LocalDate
	 */
	protected LocalDate birthdate;
	
	/**
	 * Place of Birth
	 */
	protected String placeBirth;
	
	/**
	 * Sex, 'F' or 'M'
	 */
	protected char sex;
	
	/**
	 * Date of Issue <br>
	 * LocalDate
	 */
	protected LocalDate dateIssue;
	
	/**
	 * Date of Expiry <br>
	 * LocalDate
	 */
	protected LocalDate dateExpiry;
	
	/**
	 * Place of Issue
	 */
	protected String placeIssue;
	
	public Document() {}

	public String getCountry() {
		return country;
	}

	public String getNumber() {
		return number;
	}

	public String getGivenNames() {
		return givenNames;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public String getPlaceBirth() {
		return placeBirth;
	}

	public char getSex() {
		return sex;
	}

	public LocalDate getDateIssue() {
		return dateIssue;
	}

	public LocalDate getDateExpiry() {
		return dateExpiry;
	}

	public String getPlaceIssue() {
		return placeIssue;
	}
}
