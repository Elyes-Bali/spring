package esprit.se.foyer.controller;

import esprit.se.foyer.entities.Chambre;
import esprit.se.foyer.entities.Etudient;
import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.entities.TypeChambre;
import esprit.se.foyer.services.IChambreServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreServices chambreServices;

    @GetMapping("/retrieve-all-chambre")
    public List<Chambre> getChambre() {
        List<Chambre> chambre = chambreServices.retrieveAllChambre();
        return chambre;
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {

        Chambre addedchambre = chambreServices.addChambre(chambre);
        return addedchambre;
    }

    @PutMapping("/update-chambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreServices.updateChambre(chambre);
    }

    @GetMapping("/retrieve-chambre/{idChambre}")
    public Chambre getChambre(@PathVariable Long idChambre) {
        return chambreServices.retrieveChambre(idChambre);
    }

    @DeleteMapping("/remove-chambre/{idChambre}")
    public void removeChambre(@PathVariable Long idChambre) {
        chambreServices.removeChambre(idChambre);
    }

    @PutMapping("/afficher/{numeroChambre}/{nomBlock}")
    public Chambre affecterChambresABloc(@PathVariable ("numeroChambre") List<Long> numeroChambre , @PathVariable ("nomBlock") String nomBloc ){
        return chambreServices.affecterChambresABloc(numeroChambre,nomBloc);
    }

    @GetMapping("/AfficheChambre/{nomBloc}")
    public List<Chambre> getChambresParNomBloc(@PathVariable ("nomBloc") String nomBloc) {
        return chambreServices.getChambresParNomBloc(nomBloc);
    }

    @GetMapping("/getChambresParBlocEtType/{typeC}/{idBloc}")
    List<Chambre> nbChambreParTypeEtBloc(@PathVariable ("typeC") TypeChambre typeC,@PathVariable ("idBloc") long idBloc ){
        return chambreServices.nbChambreParTypeEtBloc(typeC,idBloc);
    }
}

