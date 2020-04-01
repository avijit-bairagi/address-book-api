package com.avijit.addressbook.contact.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactPostDTO {

    @NotNull(message = "name must not be null")
    private String name;

    @NotNull(message = "address must not be null")
    private String address;

    @NotNull(message = "phoneNumber must not be null")
    private String phoneNumber;

}
