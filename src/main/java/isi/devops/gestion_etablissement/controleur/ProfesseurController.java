package isi.devops.gestion_etablissement.controleur;

import isi.devops.gestion_etablissement.domaine.Professeur;
import isi.devops.gestion_etablissement.service.ProfesseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
@CrossOrigin("*")
public class ProfesseurController {

    private final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @PostMapping
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurService.createProfesseur(professeur);
    }

    @GetMapping("/{id}")
    public Professeur getProfesseur(@PathVariable Long id) {
        return professeurService.getProfesseurById(id);
    }

    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    @PutMapping("/{id}")
    public Professeur updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeur) {
        return professeurService.updateProfesseur(id, professeur);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
    }
}
