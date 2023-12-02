package esprit.se.foyer.controller;

import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.services.IEtudiantServices;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantServices etudiantServices;
    @GetMapping("/retrieve")
    public List<Etudient> getEtudiants() {
        List<Etudient> etudiants = etudiantServices.retrieveAllEtudiants();
        return etudiants;
}

    @PostMapping("/add-etudiant")
    public Etudient addEtudiant(@RequestBody Etudient etudiant) {

        Etudient addedEtudient = etudiantServices.addEtudiant(etudiant);
        return addedEtudient;
    }

    @PutMapping("/update-etudiant")
    public Etudient updateEtudiant(@RequestBody Etudient etudiant) {
        return etudiantServices.updateEtudiant(etudiant);
    }

    @GetMapping("/retrieve-etudiant/{id}")
    public Etudient getEtudiant(@PathVariable Long id) {
        return etudiantServices.retrieveEtudiant(id);
    }

    @DeleteMapping("/remove-etudiant/{id}")
    public void removeEtudiant(@PathVariable Long id) {
        etudiantServices.removeEtudiant(id);
    }
}
