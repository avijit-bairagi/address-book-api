package com.avijit.addressbook.address.controller;

import com.avijit.addressbook.address.dto.AddressPostDTO;
import com.avijit.addressbook.address.entity.Address;
import com.avijit.addressbook.address.service.AddressService;
import com.avijit.addressbook.common.ResponseStatus;
import com.avijit.addressbook.common.dto.Response;
import com.avijit.addressbook.common.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("address/")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    ModelMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<Response> save(@Valid @RequestBody AddressPostDTO postDTO) {

        Response response = new Response();

        Address address = addressService.save(mapper.map(postDTO, Address.class));

        response.setCode(ResponseStatus.SUCCESS.value());
        response.setCode("Address saved successfully.");
        response.setData(address);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/update/{addressId}")
    public ResponseEntity<Response> update(@Valid @RequestBody AddressPostDTO postDTO, @PathVariable(name = "addressId") Long addressId) {

        Response response = new Response();

        try {

            Address address = mapper.map(postDTO, Address.class);
            address.setId(addressId);
            address = addressService.update(address);

            response.setCode(ResponseStatus.SUCCESS.value());
            response.setCode("Address updated successfully.");
            response.setData(address);

        } catch (NotFoundException e) {
            e.printStackTrace();
            response.setCode(e.getCode());
            response.setCode(e.getMessage());
        }

        if (response.getCode().equalsIgnoreCase(ResponseStatus.SUCCESS.value()))
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.badRequest().body(response);
    }

    @GetMapping()
    public ResponseEntity<Response> getAll() {

        Response response = new Response();

        List<Address> addresses = addressService.getAll();

        response.setCode(ResponseStatus.SUCCESS.value());
        response.setCode("Address(s) fetched successfully.");
        response.setData(addresses);

        return ResponseEntity.ok(response);
    }
}
