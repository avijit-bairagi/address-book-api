package com.avijit.addressbook.contact.service;

import com.avijit.addressbook.contact.entity.Contact;
import com.avijit.addressbook.common.exception.NotFoundException;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);
    Contact update(Contact contact) throws NotFoundException;
    List<Contact> getAll();
}
