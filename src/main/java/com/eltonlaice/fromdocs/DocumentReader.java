package com.eltonlaice.fromdocs;

public class DocumentReader {
	private String type;
	
	private String file;

	public DocumentReader() {}
	
	public DocumentReader(String file, String type) {
		this.type = type;
		this.file = file;
	}
	
	public DocumentReader(String file) {
		this.file = file;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
