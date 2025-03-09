package isi.devops.gestion_etablissement.controleur;

import isi.devops.gestion_etablissement.domaine.Classe;
import isi.devops.gestion_etablissement.domaine.Etudiant;
import isi.devops.gestion_etablissement.service.ClasseService;
import isi.devops.gestion_etablissement.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/etudiants")
@CrossOrigin("*")
public class EtudiantController {

    private final EtudiantService etudiantService;
    private final ClasseService  classeService;

    public EtudiantController(EtudiantService etudiantService, ClasseService classeService) {
        this.etudiantService = etudiantService;
        this.classeService = classeService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        List<Classe> classes = classeService.getAllClasses();
        model.addAttribute("classes", classes);
        return "etudiants/createEtudiant";
    }

    @PostMapping
    public String createEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.createEtudiant(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/{id}")
    public String getEtudiant(@PathVariable Long id, Model model) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "etudiants/getEtudiant";
    }

    @GetMapping
    public String getAllEtudiants(Model model) {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "etudiants/getAllEtudiants";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "etudiants/updateEtudiant";
    }

    @PutMapping("/{id}")
    public String updateEtudiant(@PathVariable Long id, @ModelAttribute Etudiant etudiant) {
        etudiantService.updateEtudiant(id, etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "etudiants/deleteEtudiant";
    }

    @DeleteMapping("/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants";
    }
}