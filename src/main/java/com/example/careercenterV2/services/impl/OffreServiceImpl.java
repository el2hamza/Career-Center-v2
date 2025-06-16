package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.mappers.OffreMapper;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;
import com.example.careercenterV2.repositories.OffreRepository;
import com.example.careercenterV2.services.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OffreServiceImpl implements OffreService {

    private final OffreRepository offreRepository;
    private final OffreMapper offreMapper;

    @Override
    public List<OffreResponse> getAllOffre() {
        List<Offre> offres=  offreRepository.findAll();
        return offreMapper.listToResponseList(offres);
    }

    @Override
    public OffreResponse addOffre(AddOffreRequest addOffreRequest) {
        Offre offre = offreMapper.requestToEntity(addOffreRequest);
        return offreMapper.entityToResponse(offreRepository.save(offre));
    }

    @Override
    public OffreResponse editOffre(EditOffreRequest request, long id) {
        Offre offre = offreRepository.findById(id).orElseThrow();
        offreMapper.updateEntity(request, offre);
        return offreMapper.entityToResponse(offreRepository.save(offre));
    }

    @Override
    public void deleteOffre(long id) {
        if (!offreRepository.existsById(id)) {
            throw new IllegalArgumentException("Offre not found");
        }
        offreRepository.deleteById(id);
    }

    @Override
    public List<OffreResponse> getOffreByType(String type) {
        List<Offre> offres= offreRepository.findByType(type);
        return offreMapper.listToResponseList(offres);
    }

    @Override
    public List<OffreResponse> getOffreBySecteur(String secteur) {
        List<Offre> offres= offreRepository.findBySecteur(secteur);
        return offreMapper.listToResponseList(offres);
    }

    @Override
    public List<OffreResponse> getExpiredOffres() {
        List<Offre> offres= offreRepository.findByDateClotureBefore(new Date());
        return offreMapper.listToResponseList(offres);
    }


}
