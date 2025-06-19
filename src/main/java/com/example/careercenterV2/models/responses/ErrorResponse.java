package com.example.careercenterV2.models.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Getter
@Setter
@Builder
public class ErrorResponse {

    String message;
    String location;
    String description;
    Date timestamp;
}
