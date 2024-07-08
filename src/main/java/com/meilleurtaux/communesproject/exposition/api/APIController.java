package com.meilleurtaux.communesproject.exposition.api;

import com.meilleurtaux.communesproject.application.commune.CommuneDTO;
import com.meilleurtaux.communesproject.application.commune.CommuneManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private CommuneManagement communeManagement;

    @GetMapping("/communes")
    public List<CommuneDTO> getCommunes(@RequestParam(value = "postalCode") String postalCode) {
        return communeManagement.getCommuneList(postalCode);
    }

}
