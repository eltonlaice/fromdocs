package com.eltonlaice.fromdocs;

import com.eltonlaice.fromdocs.services.IdService;
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
		IdService idService = new IdService(data);
		Document document = new Document();
		document.setNumber(idService.getNumber());
		document.setLastName(idService.getLastName());
		document.setGivenNames(idService.getGivenNames());
		document.setBirthdate(idService.getBirthdate());
		return document;
	}

	public Passport processPassport(String data) {
		System.out.println("PASSPORT");
		Passport passport = new Passport();
		return passport;
	}
}
