package com.eltonlaice.fromdocs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PassportTest {
	private String path_file;
	private DocumentReader reader;
	
	@Before
	public void init() {
		this.path_file = "/path/docfile.pdf";
		this.reader = new DocumentReader(this.path_file, DocumentType.PASSPORT);
	}
	
	@Test
	public void testValidFile() {
		assertTrue(this.reader.getData().length() > 0);
	}
	
	@Test
	public void testNumber() {
		assertEquals(this.reader.getDocument().getNumber(), "100101111111P");
	}	
	
	@Test
	public void testNames() {
		assertEquals(this.reader.getDocument().getLastName(), "LAICE");
		assertEquals(this.reader.getDocument().getGivenNames(), "ELTON TOMAS");
	}
	
	@Test
	public void testBirthdate() {
		assertEquals(this.reader.getDocument().getBirthdate().getDayOfMonth(), 8);
		assertEquals(this.reader.getDocument().getBirthdate().getMonthValue(), 6);
		assertEquals(this.reader.getDocument().getBirthdate().getYear(), 1990);
	}
	
	@Test
	public void testDateIssue() {
		assertEquals(this.reader.getDocument().getDateIssue().getDayOfMonth(), 12);
		assertEquals(this.reader.getDocument().getDateIssue().getMonthValue(), 1);
		assertEquals(this.reader.getDocument().getDateIssue().getYear(), 2012);
	}
}
