package esprit.se.foyer.services;

import esprit.se.foyer.entities.Chambre;
import esprit.se.foyer.entities.TypeChambre;


import java.util.List;

public interface IChambreServices {
    List<Chambre> retrieveAllChambre();

    Chambre addChambre(Chambre e);

    Chambre updateChambre(Chambre e);

    Chambre retrieveChambre(Long idChambre);

    void removeChambre(Long idChambre);
    Chambre affecterChambresABloc(List<Long> numeroChambre, String nomBloc);
    void pourcentageChambreParTypeChambre();
    void listeChambresParBloc();
    List<Chambre> getChambresParNomBloc( String nomBloc );
    List<Chambre> nbChambreParTypeEtBloc(TypeChambre type, long idBloc );

}
