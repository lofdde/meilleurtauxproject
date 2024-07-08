package com.meilleurtaux.communesproject.application.commune;

import com.meilleurtaux.communesproject.domain.commune.Commune;
import com.meilleurtaux.communesproject.domain.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneManagement {

    @Autowired
    private CommuneService communeService;
    public List<CommuneDTO> getCommuneList(String postalCode){
        return communeService.getCommuneList(postalCode).stream().map(this::communeToDTO).toList();
    }

    private CommuneDTO communeToDTO(Commune commune){
        return new CommuneDTO(commune.nom(), commune.population());
    }
}
