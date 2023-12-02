package esprit.se.foyer.controller;

import esprit.se.foyer.entities.Universite;
import esprit.se.foyer.services.IUniversiteServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/university")
public class UniversiteController  {
    IUniversiteServices universiteServices;
    @GetMapping("/retrieve-all-universities")
    public List<Universite> getUniversite() {
        List<Universite> universite = universiteServices.retrieveAllUniversities();
        return universite;
    }
    @PostMapping("/add-university")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteServices.addUniversity(universite);
    }

    @PutMapping("/update-university")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteServices.updateUniversity(universite);
    }

    @GetMapping("/retrieve-university/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return universiteServices.retrieveUniversite(id);
    }

    @DeleteMapping("/remove-university/{id}")
    public void removeUniversite(@PathVariable Long id) {
        universiteServices.removeUniversite(id);
    }




}
