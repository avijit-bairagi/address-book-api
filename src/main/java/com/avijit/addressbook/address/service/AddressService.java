package com.avijit.addressbook.address.service;

import com.avijit.addressbook.address.entity.Address;
import com.avijit.addressbook.common.exception.AlreadyExitException;
import com.avijit.addressbook.common.exception.NotFoundException;

import java.util.List;

public interface AddressService {

    Address save(Address address);
    Address update(Address address) throws NotFoundException;
    List<Address> getAll();
}
