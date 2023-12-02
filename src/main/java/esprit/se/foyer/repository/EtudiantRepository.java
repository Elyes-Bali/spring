package esprit.se.foyer.repository;

import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudient,Long> {
//    Etudient findByNomEtudient(String nomEt);

}
