package com.avijit.addressbook.contact.controller;

import com.avijit.addressbook.common.ResponseStatus;
import com.avijit.addressbook.common.dto.Response;
import com.avijit.addressbook.common.exception.NotFoundException;
import com.avijit.addressbook.contact.dto.ContactPostDTO;
import com.avijit.addressbook.contact.entity.Contact;
import com.avijit.addressbook.contact.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("contact/")
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    ModelMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<Response> save(@Valid @RequestBody ContactPostDTO postDTO) {

        Response response = new Response();

        Contact contact = contactService.save(mapper.map(postDTO, Contact.class));

        response.setCode(ResponseStatus.SUCCESS.value());
        response.setMessage("Contact saved successfully.");
        response.setData(contact);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/update/{contactId}")
    public ResponseEntity<Response> update(@Valid @RequestBody ContactPostDTO postDTO, @PathVariable(name = "contactId") Long contactId) {

        Response response = new Response();

        try {

            Contact contact = mapper.map(postDTO, Contact.class);
            contact.setId(contactId);
            contact = contactService.update(contact);

            response.setCode(ResponseStatus.SUCCESS.value());
            response.setMessage("Contact updated successfully.");
            response.setData(contact);

        } catch (NotFoundException e) {
            e.printStackTrace();
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        }

        if (response.getCode().equalsIgnoreCase(ResponseStatus.SUCCESS.value()))
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.badRequest().body(response);
    }

    @GetMapping()
    public ResponseEntity<Response> getAll() {

        Response response = new Response();

        List<Contact> contacts = contactService.getAll();

        response.setCode(ResponseStatus.SUCCESS.value());
        response.setMessage("Contact(s) fetched successfully.");
        response.setData(contacts);

        return ResponseEntity.ok(response);
    }
}
