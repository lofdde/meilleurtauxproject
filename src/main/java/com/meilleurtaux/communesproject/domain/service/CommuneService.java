package com.meilleurtaux.communesproject.domain.service;

import com.meilleurtaux.communesproject.domain.commune.Commune;
import com.meilleurtaux.communesproject.domain.commune.CommuneClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneService {

    @Autowired
    private CommuneClient communeClient;

    public List<Commune> getCommuneList(String postalCode){
        return communeClient.getCommuneList(postalCode);
    }

}
