package esprit.se.foyer.controller;

import esprit.se.foyer.entities.Bloc;
import esprit.se.foyer.entities.Foyer;
import esprit.se.foyer.services.IBlockSrvices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlockRestController {
    IBlockSrvices blockSrvices;
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBloc() {
        return blockSrvices.retrieveAllBlocs();
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blockSrvices.addBloc(bloc);
    }

    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blockSrvices.updateBloc(bloc);
    }

    @GetMapping("/retrieve-bloc/{id}")
    public Bloc retrieveBloc(@PathVariable Long id) {
        return blockSrvices.retrieveBloc(id);
    }

    @DeleteMapping("/remove-bloc/{id}")
    public void removeBloc(@PathVariable Long id) {
        blockSrvices.removeBloc(id);
    }
}
