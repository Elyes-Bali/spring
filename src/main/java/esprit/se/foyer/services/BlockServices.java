package esprit.se.foyer.services;

import esprit.se.foyer.entities.Bloc;
import esprit.se.foyer.entities.Chambre;
import esprit.se.foyer.repository.BlocRepository;
import esprit.se.foyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Slf4j
@Service
@AllArgsConstructor
public class BlockServices implements IBlockSrvices{
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }



    @Scheduled(fixedRate = 10000)
    public void listeChambresParBloc() {
        List<Bloc> blocs;
         blocRepository.findAll().forEach(bloc->{
            log.info("bloc"+bloc.getNomBloc()+" de capacité "+bloc.getCapBloc());
                    bloc.getChambre().forEach(chambre -> {
                        log.info("Chambre numero " + chambre.getNumeroChambre() + " et de type " + chambre.getTypeC());
                    });

    });
    }



}
