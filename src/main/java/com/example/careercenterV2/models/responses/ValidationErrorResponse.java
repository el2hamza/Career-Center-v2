package com.example.careercenterV2.models.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@Builder
public class ValidationErrorResponse {

    private int errorCode;
    private String errorMessage;
    private Map<String, String> validationErrors;
}
