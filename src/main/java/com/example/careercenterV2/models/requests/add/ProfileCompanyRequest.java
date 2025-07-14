package com.example.careercenterV2.models.requests.add;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProfileCompanyRequest {

    private UUID id;
    private String address;
    private String phone;
    private String city ;
    private String logo;
    private String secteur ;
    private String numPattente ;
    private String description ;
    private Date creationDate ;
}
