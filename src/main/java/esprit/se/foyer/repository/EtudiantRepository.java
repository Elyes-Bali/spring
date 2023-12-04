package esprit.se.foyer.repository;

import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudient,Long> {
    @Query("SELECT e FROM Etudient e WHERE e.nomEt = :nomEt AND e.prenomEt = :prenomEt")
    Etudient findByNomEtAndPrenomEt(@Param("nomEt") String nomEt, @Param("prenomEt") String prenomEt);

}
