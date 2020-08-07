package com.eltonlaice.fromdocs;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class DocumentReader {
	private String type;
	
	private String file;
	
	private Tesseract tesseract;
	
	private Document document;
	
	private String data; 
	
	/**
	 * 
	 * @param file
	 * @param type
	 */
	public DocumentReader(String file, String type) {
		this.type = type;
		this.file = file;
		init();
	}
	
	/**
	 * 
	 */
	public void init() {
		DocumentProcess documentProcess = new DocumentProcess();
    	File image = new File(this.file);
    	this.tesseract = new Tesseract();
    	this.tesseract.setDatapath("src/main/resources/tessdata");
    	this.tesseract.setLanguage("eng");
    	this.tesseract.setPageSegMode(1);
    	this.tesseract.setOcrEngineMode(1);
    	
    	try {
			this.data = tesseract.doOCR(image);
	    	if(this.type.equalsIgnoreCase(Config.NUIT)) {
	    		documentProcess.processNuit(this.data);
	    	}if (this.type.equalsIgnoreCase(Config.BI) || this.type.equalsIgnoreCase(Config.ID)) {
	    		documentProcess.processId(this.data);
			}else if (this.type.equalsIgnoreCase(Config.PASSPORT)) {
				documentProcess.processPassport(this.data);
			}else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return
	 */
	public String getFile() {
		return file;
	}

	/**
	 * 
	 * @param file
	 */
	public void setFile(String file) {
		this.file = file;
	}

	public String getData() {
		return data;
	}
}
