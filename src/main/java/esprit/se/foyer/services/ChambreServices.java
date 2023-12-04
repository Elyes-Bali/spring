package esprit.se.foyer.services;

import esprit.se.foyer.entities.*;
import esprit.se.foyer.repository.BlocRepository;
import esprit.se.foyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    @Scheduled(fixedRate = 2000)
    @Override
    public void pourcentageChambreParTypeChambre() {
        long totalChambres = chambreRepository.count();

        for (TypeChambre type : TypeChambre.values()) {
            long countByType = chambreRepository.countByTypeC(type);
            double percentage = (countByType * 100.0) / totalChambres;
            log.info("le poucentage des chambres pour le type " + type + " est égale à " + percentage + "%");
        }
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


    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);

        if (bloc != null) {
            Set<Bloc> blocs = bloc.getFoyer().getBloc();
            List<Chambre> chambres = new ArrayList<>();

            for (Bloc Cbloc : blocs) {
                chambres.addAll(Cbloc.getChambre());
            }

            return chambres;
        }

        return Collections.emptyList();
    }

    @Override
    public List<Chambre> nbChambreParTypeEtBloc(TypeChambre typeC, long idBloc) {
        return chambreRepository.findChambresByTypeCAndBloc_IdBloc(typeC,idBloc);
    }

}