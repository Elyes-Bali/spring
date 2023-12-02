package esprit.se.foyer.controller;

import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.entities.Reservation;
import esprit.se.foyer.services.IEtudiantServices;
import esprit.se.foyer.services.IReservationServices;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(EtudiantController.class);
    IReservationServices reservationServices;
    @GetMapping("/retrieve-all-reservation")
    public List<Reservation> getReservation() {
        List<Reservation> etudiants = reservationServices.retrieveAllReservation();
        return etudiants;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation etudiant) {
        logger.debug("Adding student: {}", etudiant);
        Reservation addedEtudient = reservationServices.addReservation(etudiant);

        return addedEtudient;
    }

    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationServices.updateReservation(reservation);
    }

    @GetMapping("/retrieve-reservation/{id}")
    public Reservation getReservation(@PathVariable String idReservation) {
        return reservationServices.retrieveReservation(idReservation);
    }

    @DeleteMapping("/remove-reservation/{id}")
    public void removeReservation(@PathVariable String idReservation) {
        reservationServices.removeReservation(idReservation);
    }
}
