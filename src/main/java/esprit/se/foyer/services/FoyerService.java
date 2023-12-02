package esprit.se.foyer.services;

import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.entities.Universite;
import esprit.se.foyer.repository.FoyerRepository;
import esprit.se.foyer.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerServices {
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer affecterFoyerAUniversite(Long idFoyer, String nomUnivertsite){
        Foyer foyer=foyerRepository.findById(idFoyer).get();
        Universite universite = universiteRepository.findByNomUniversite(nomUnivertsite);
        foyer.setUniversite(universite);
        foyerRepository.save(foyer);
        return foyer;
    }

    @Override
    public Foyer desaffecterFoyerAUniversite(Long idFoyer){
        Foyer foyer=foyerRepository.findById(idFoyer).get();
        foyer.setUniversite(null);
        foyerRepository.save(foyer);
        return foyer;
    }

}
