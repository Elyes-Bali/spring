package esprit.se.foyer.repository;

import esprit.se.foyer.entities.Bloc;
import esprit.se.foyer.entities.Chambre;
import esprit.se.foyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChambreRepository extends JpaRepository<Chambre,Long > {
    Chambre findByNumeroChambre(Long numeroChambre);

    @Query("select count (c) from Chambre c where c.typeC= :type")
    int coutparType(@Param("type")TypeChambre t);
}
