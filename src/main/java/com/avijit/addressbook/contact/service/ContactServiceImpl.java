package com.avijit.addressbook.contact.service;

import com.avijit.addressbook.contact.entity.Contact;
import com.avijit.addressbook.contact.repository.ContactRepository;
import com.avijit.addressbook.common.ResponseStatus;
import com.avijit.addressbook.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {

        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) throws NotFoundException {

        if (contactRepository.findById(contact.getId()).isEmpty())
            throw new NotFoundException(ResponseStatus.NOT_FOUND.value(), "Contact not found!");

        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
