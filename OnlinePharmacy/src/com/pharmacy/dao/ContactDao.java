package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Contact;

public interface ContactDao 
{
	boolean addContact(Contact contact);
	List<Contact> showAllContact();

}
