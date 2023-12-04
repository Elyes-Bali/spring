package esprit.se.foyer.services;

import esprit.se.foyer.entities.Bloc;

import java.util.List;

public interface IBlockSrvices {
    List<Bloc> retrieveAllBlocs();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(Long idBloc);

    void removeBloc(Long idBloc);



    void listeChambresParBloc();

}
