package com.dollop.dao;

import java.util.ArrayList;

import com.dollop.model.Contact;

public interface ContactInterface {

	public boolean createContact(Contact contact);
	public ArrayList<Contact>viewAllContact();
	public  Contact viewContactById(int id);
	public boolean updateContact(Contact contact);
	public boolean deleteContact(int parseInt);
}
