package com.meilleurtaux.communesproject.domain.commune;

import java.util.List;

public interface CommuneClient {
    List<Commune> getCommuneList(String postalCode);
}
