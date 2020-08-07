package com.eltonlaice.fromdocs;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DocumentReaderTest {
	private String path_nuit;
	
	@Before
	public void init() {
		this.path_nuit = "/home/elton/Desktop/fromdocs/docs/NUIT.pdf";
	}
	
	@Test
	public void testValidFile() {
		DocumentReader reader = new DocumentReader(this.path_nuit, "NUIT");
		assertTrue(reader.getData().length() > 0);
	}
}
