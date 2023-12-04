package esprit.se.foyer.services;

import esprit.se.foyer.entities.Etudient;

import java.util.List;

public interface IEtudiantServices {
    List<Etudient> retrieveAllEtudiants();

    Etudient addEtudiant(Etudient e);

    Etudient updateEtudiant(Etudient e);

    Etudient retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);

    Etudient affecterEtudiantAReservation(String nomEt , String prenomEt , String idReservation );
}
