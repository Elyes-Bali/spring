package esprit.se.foyer.services;

import esprit.se.foyer.entities.Chambre;


import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambre();

    Chambre addChambre(Chambre e);

    Chambre updateChambre(Chambre e);

    Chambre retrieveChambre(Long idChambre);

    void removeChambre(Long idChambre);
    Chambre affecterChambresABloc(List<Long> numeroChambre, String nomBloc);
//    void pourcentageChambreParTypeChambre();
    void listeChambresParBloc();

}
