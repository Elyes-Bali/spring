package esprit.se.foyer.services;

import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversities();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u);
    Universite retrieveUniversite (Long idUniversite);
    void removeUniversite  (Long idUniversite );


}
