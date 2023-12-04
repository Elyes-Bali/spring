package esprit.se.foyer.controller;


import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.services.IEtudiantServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @Operation(description = "get etudiant by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "found etudiant", content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Etudient.class))}),
            @ApiResponse(responseCode = "400",description = "Invalid supplied",content = @Content),
            @ApiResponse(responseCode = "404",description = "Etudiant not found",content = @Content)
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody
    public Etudient getEtudiant(@Parameter(description = "id of student to be searched") @PathVariable Long id) {
        return etudiantServices.retrieveEtudiant(id);
    }

    @DeleteMapping("/remove-etudiant/{id}")
    public void removeEtudiant(@PathVariable Long id) {
        etudiantServices.removeEtudiant(id);
    }


    @PutMapping("/affecter/{nomEt}/{prenomEt}/{idReservation}")
    public Etudient affecterEtudiantAReservation(
            @PathVariable("nomEt") String nomEt,
            @PathVariable("prenomEt") String prenomEt,
            @PathVariable("idres") String idReservation) {
        return etudiantServices.affecterEtudiantAReservation(nomEt, prenomEt, idReservation);
    }

}
