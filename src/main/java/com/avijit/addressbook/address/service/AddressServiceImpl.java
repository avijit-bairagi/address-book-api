package com.avijit.addressbook.address.service;

import com.avijit.addressbook.address.entity.Address;
import com.avijit.addressbook.address.repository.AddressRepository;
import com.avijit.addressbook.common.ResponseStatus;
import com.avijit.addressbook.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address save(Address address) {

        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) throws NotFoundException {

        if (addressRepository.findById(address.getId()).isEmpty())
            throw new NotFoundException(ResponseStatus.NOT_FOUND.value(), "Address not found!");

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
