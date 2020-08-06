package com.eltonlaice.fromdocs;

public class DocumentProcess {
	public Nuit processNuit(String data) {
		Nuit nuit = new Nuit();
		System.out.println("NUIT");
		return nuit;
	}

	public Document processId(String data) {
		System.out.println("ID");
		Document document = new Document();
		return document;
	}

	public Passport processPassport(String data) {
		System.out.println("PASSPORT");
		Passport passport = new Passport();
		return passport;
	}
}
