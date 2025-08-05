package com.example.careercenterV2.models.responses;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public class CandidatureResponse {
    private UUID id;
    private UUID candidatId;
    private long offreId;
    private Date dateSoumission;
    private String status;
}
