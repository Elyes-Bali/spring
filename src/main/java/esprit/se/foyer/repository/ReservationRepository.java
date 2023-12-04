package esprit.se.foyer.repository;

import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
//    Reservation findbyidres(String idReservation);
}
