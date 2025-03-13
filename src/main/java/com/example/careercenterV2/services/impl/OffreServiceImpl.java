package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;
import com.example.careercenterV2.repositories.CompanyRepository;
import com.example.careercenterV2.repositories.OffreRepository;
import com.example.careercenterV2.services.OffreService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class OffreServiceImpl implements OffreService {

    private final OffreRepository offreRepository;
    private final CompanyRepository companyRepository;

    public OffreServiceImpl(OffreRepository offreRepository, CompanyRepository companyRepository) {
        this.offreRepository = offreRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public OffreResponse addOffre(AddOffreRequest offreRequest) throws Exception{
        //check if offre exist by reference
        Optional<Offre> offreOptional= offreRepository.findByReference(offreRequest.getReference());
        if(offreOptional.isPresent())
            throw new Exception("Offre already exists");

        UUID companyId = offreRequest.getCompanyId();
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new Exception("Company not found"));


        Offre build = Offre.builder()
                .reference(offreRequest.getReference())
                .titre(offreRequest.getTitre())
                .description(offreRequest.getDescription())
                .type(offreRequest.getType())
                .secteur(offreRequest.getSecteur())
                .city(offreRequest.getCity())
                .state(offreRequest.getState())
                .datePublication(offreRequest.getDatePublication())
                .dateCloture(offreRequest.getDateCloture())
                .company(company)
                .build() ;

        Offre saved = offreRepository.save(build);

        return OffreResponse.builder()
                .id(saved.getId())
                .titre(saved.getTitre())
                .reference(saved.getReference())
                .datePublication(saved.getDatePublication())
                .build() ;

    }

    @Override
    public List<Offre> getAllOffre() {
        return offreRepository.findAll();
    }

    @Override
    public OffreResponse editOffre(EditOffreRequest offreRequest , long id) throws Exception{

        Offre offre = offreRepository.findById(id)
                .orElseThrow(() -> new Exception("Offre not found"));

        if (offreRequest.getTitre() != null) {
            offre.setTitre(offreRequest.getTitre());
        }
        if (offreRequest.getDescription() != null) {
            offre.setDescription(offreRequest.getDescription());
        }
        if (offreRequest.getType() != null) {
            offre.setType(offreRequest.getType());
        }
        if (offreRequest.getSecteur() != null) {
            offre.setSecteur(offreRequest.getSecteur());
        }
        if (offreRequest.getCity() != null) {
            offre.setCity(offreRequest.getCity());
        }
        if (offreRequest.getState() != null) {
            offre.setState(offreRequest.getState());
        }
        if (offreRequest.getDateCloture() != null) {
            offre.setDateCloture(offreRequest.getDateCloture());
        }

        Offre updated = offreRepository.save(offre);

        return new OffreResponse(
                updated.getId(),
                updated.getReference(),
                updated.getTitre(),
                updated.getDescription(),
                updated.getType(),
                updated.getSecteur(),
                updated.getCity(),
                updated.getState(),
                updated.getDatePublication(),  // Keep original publication date
                updated.getDateCloture() ) ;



    }

    @Override
    public void deleteOffre(long id) throws Exception {
        // Vérifier si l'offre existe
        Offre offre = offreRepository.findById(id)
                .orElseThrow(() -> new Exception("Offre non trouvée"));

        // Supprimer l'offre
        offreRepository.delete(offre);
    }

    @Override
    public List<Offre> getExpiredOffres() throws Exception {
        Date today = new Date();  // Date actuelle
        List<Offre> offres = offreRepository.findByDateClotureBefore(today);

        if (offres.isEmpty()) {
            throw new Exception("Aucune offre expirée trouvée.");
        }
        return offres;
    }

    @Override
    public List<Offre> getOffreByType(String type) throws Exception {
        List<Offre> offres = offreRepository.findByType(type);
        if (offres.isEmpty()) {
            throw new Exception("Aucune offre trouvée pour le type: " + type);
        }
        return offres;
    }

    @Override
    public List<Offre> getOffreBySecteur(String secteur) throws Exception {
        List<Offre> offres = offreRepository.findBySecteur(secteur);
        if (offres.isEmpty()) {
            throw new Exception("Aucune offre trouvée pour le secteur: " + secteur);
        }
        return offres;
    }




}
