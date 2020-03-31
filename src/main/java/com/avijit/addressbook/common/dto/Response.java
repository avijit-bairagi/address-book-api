package com.avijit.addressbook.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String code;

    private String message;

    private Object data;
}
