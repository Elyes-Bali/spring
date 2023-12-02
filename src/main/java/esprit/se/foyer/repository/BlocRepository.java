package esprit.se.foyer.repository;

import esprit.se.foyer.entities.Bloc;
import esprit.se.foyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    Bloc findByNomBloc(String nomBloc);
}
