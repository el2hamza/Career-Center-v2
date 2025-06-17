package com.example.careercenterV2.models.requests.add;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProfileCompanyRequest {

    private String address;
    private String phone;
    private String city ;
    private String logo;
    private String secteur ;
    private String numPattente ;
    private String description ;
    private Date creationDate ;
}
