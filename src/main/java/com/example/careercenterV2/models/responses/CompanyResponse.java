package com.example.careercenterV2.models.responses;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Builder
public class CompanyResponse {

    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String city ;
    private String logo;
    private String secteur ;
    private String numPattente ;
    private String description ;
    private Date creationDate ;
}
