package com.avijit.addressbook.address.dto;

import javax.validation.constraints.NotNull;

public class AddressPostDTO {

    @NotNull(message = "name must not be null")
    private String name;

    @NotNull(message = "address must not be null")
    private String address;

    @NotNull(message = "phoneNumber must not be null")
    private String phoneNumber;

}
