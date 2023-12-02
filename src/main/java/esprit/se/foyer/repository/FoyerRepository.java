package esprit.se.foyer.repository;

import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.entities.Universite;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long>{

}
