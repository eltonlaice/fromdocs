package com.eltonlaice.fromdocs;

import com.eltonlaice.fromdocs.services.NuitService;

public class DocumentProcess {
	public Nuit processNuit(String data) {
		NuitService nuitService = new NuitService(data);
		Nuit nuit = new Nuit();
		nuit.setNumber(nuitService.getNumber());
		nuit.setLastName(nuitService.getLastName());
		nuit.setGivenNames(nuitService.getGivenNames());
		nuit.setBirthdate(nuitService.getBirthdate());
		nuit.setDateIssue(nuitService.getDateIssue());
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
