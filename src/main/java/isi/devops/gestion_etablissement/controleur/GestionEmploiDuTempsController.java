package isi.devops.gestion_etablissement.controleur;

import isi.devops.gestion_etablissement.domaine.GestionEmploiDuTemps;
import isi.devops.gestion_etablissement.service.GestionEmploiDuTempsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emploi-du-temps")
@CrossOrigin("*")
public class GestionEmploiDuTempsController {

    private final GestionEmploiDuTempsService gestionEmploiDuTempsService;

    public GestionEmploiDuTempsController(GestionEmploiDuTempsService gestionEmploiDuTempsService) {
        this.gestionEmploiDuTempsService = gestionEmploiDuTempsService;
    }

    @PostMapping
    public GestionEmploiDuTemps createEmploiDuTemps(@RequestBody GestionEmploiDuTemps gestionEmploiDuTemps) {
        return gestionEmploiDuTempsService.createEmploiDuTemps(gestionEmploiDuTemps);
    }

    @GetMapping("/{id}")
    public GestionEmploiDuTemps getEmploiDuTemps(@PathVariable Long id) {
        return gestionEmploiDuTempsService.getEmploiDuTempsById(id);
    }

    @GetMapping
    public List<GestionEmploiDuTemps> getAllEmploisDuTemps() {
        return gestionEmploiDuTempsService.getAllEmploisDuTemps();
    }

    @PutMapping("/{id}")
    public GestionEmploiDuTemps updateEmploiDuTemps(@PathVariable Long id, @RequestBody GestionEmploiDuTemps gestionEmploiDuTemps) {
        return gestionEmploiDuTempsService.updateEmploiDuTemps(id, gestionEmploiDuTemps);
    }

    @DeleteMapping("/{id}")
    public void deleteEmploiDuTemps(@PathVariable Long id) {
        gestionEmploiDuTempsService.deleteEmploiDuTemps(id);
    }
}
