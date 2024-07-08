package com.meilleurtaux.communesproject.infrastructure.error;

import com.meilleurtaux.communesproject.domain.commune.Commune;
import com.meilleurtaux.communesproject.domain.commune.CommuneClient;
import com.meilleurtaux.communesproject.domain.exception.APITechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommuneClientImpl implements CommuneClient {

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Commune> getCommuneList(String postalCode) {
        Commune[] response = restTemplate.getForObject(getCommunesCallUrl(postalCode), Commune[].class);
        if(response == null){
            throw new APITechnicalException("Technical error during the call of the api, response is null", "ERROR_TECH");
        }
        return List.of(response);
    }

    private String getCommunesCallUrl(String postalCode){
        return baseUrl+"/communes?codePostal="+postalCode;
    }


}
