package com.example.careercenterV2.models.requests.add;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor

public class AddCandidatureRequest {

    UUID candidatId;
    long offreId;
    Date dateSoumission;
    String status;
}
