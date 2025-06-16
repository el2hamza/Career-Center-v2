package com.example.careercenterV2.models.requests.edit;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EditCandidatureRequest {
    private UUID candidatId;
    private long offreId;
    private Date dateSoumission;
    private String status;
}
