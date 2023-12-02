package esprit.se.foyer.services;


import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.entities.Universite;

import java.util.List;

public interface IFoyerServices {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(Long idFoyer);

    void removeFoyer(Long idFoyer);

     Foyer affecterFoyerAUniversite(Long idFoyer , String nomUnivertsite);

     Foyer desaffecterFoyerAUniversite(Long idFoyer);
}
