package esprit.se.foyer.services;

import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.entities.Reservation;
import esprit.se.foyer.entities.Universite;
import esprit.se.foyer.repository.EtudiantRepository;
import esprit.se.foyer.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantService implements IEtudiantServices{
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;
    @Override
    public List<Etudient> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override

    public Etudient addEtudiant(Etudient e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudient updateEtudiant(Etudient e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudient retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudient affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Etudient etudiant = etudiantRepository.findByNomEtAndPrenomEt(nomEt,prenomEt);
        Reservation reservation = reservationRepository.findById(idReservation).get();

        if (etudiant != null && reservation != null) {
            Set<Reservation> reservations = etudiant.getReservation();
            if (reservations == null) {
                reservations = new HashSet<>();
            }
            reservations.add(reservation);
            etudiant.setReservation(reservations);

            // Add the etudiant to the reservation as well
            reservation.getEtudiant().add(etudiant);

            etudiantRepository.save(etudiant);
            reservationRepository.save(reservation);
        }

        return etudiant;
    }


}
