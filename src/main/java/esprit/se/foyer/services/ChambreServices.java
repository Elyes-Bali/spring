package esprit.se.foyer.services;

import esprit.se.foyer.entities.*;
import esprit.se.foyer.repository.BlocRepository;
import esprit.se.foyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.juli.logging.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreServices implements IChambreServices{
ChambreRepository chambreRepository;
BlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override

    public Chambre addChambre(Chambre e) {
        return chambreRepository.save(e);
    }

    @Override
    public Chambre updateChambre(Chambre e) {
        return chambreRepository.save(e);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre affecterChambresABloc(List<Long> numeroChambre, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        numeroChambre.forEach(numero -> {
            Chambre c = chambreRepository.findByNumeroChambre(numero);
            c.setBloc(bloc);
            chambreRepository.save(c);
        });
        return null;
    }

    @Scheduled(fixedRate = 5000)
    public void listeChambresParBloc() {
        List<Bloc> blocs;
        blocRepository.findAll().forEach(
                bloc -> {
                    log.info("bloc" + bloc.getNomBloc() + " de capacité " + bloc.getCapBloc());
                    bloc.getChambre().forEach(chambre -> {
                        log.info("Chambre numero " + chambre.getNumeroChambre() + " et de type " + chambre.getTypeC());
                    });
                });
    }

//    @Scheduled(fixedRate = 5000)
//    public void pourcentageChambreParTypeChambre(){
//        long nbChamber = chambreRepository.count();
//        for (int i=0;i>TypeChambre.values().length);
//    }


}