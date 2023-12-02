package esprit.se.foyer.controller;

import esprit.se.foyer.entities.Foyer;

import esprit.se.foyer.services.IFoyerServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/foyers")
public class FoyerController {
    IFoyerServices foyerServices;
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> foyer = foyerServices.retrieveAllFoyers();
        return foyer;
    }
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerServices.addFoyer(foyer);
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerServices.updateFoyer(foyer);
    }

    @GetMapping("/retrieve-foyer/{id}")
    public Foyer getFoyer(@PathVariable Long id) {
        return foyerServices.retrieveFoyer(id);
    }

    @DeleteMapping("/remove-foyer/{id}")
    public void removeFoyer(@PathVariable Long id) {
        foyerServices.removeFoyer(id);
    }

    @PutMapping("/afficher/{nomUnversite}/{idFoyer}")
    public Foyer affecterFoyerAUniversite(@PathVariable ("nomUnversite") String nomUnversite ,@PathVariable ("idFoyer") Long idFoyer ){
        Foyer foyer = foyerServices.affecterFoyerAUniversite(idFoyer,nomUnversite);
        return  foyer;
    }

    @PutMapping("/des-Foyeruniversitieand/{idFoyer}")
    @ResponseBody
    public Foyer desaffecterFoyerAUniversite(@PathVariable("idFoyer") Long idFoyer) {
        Foyer foyer = foyerServices.desaffecterFoyerAUniversite(idFoyer);
        return foyer;
    }
}
