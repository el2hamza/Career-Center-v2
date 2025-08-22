package com.example.careercenterV2.mappers;


public interface ApplicationMapper<RQ,RS, ET> {

    ET requestToEntity(RQ request);
    RS entityToResponse(ET entity);
}
