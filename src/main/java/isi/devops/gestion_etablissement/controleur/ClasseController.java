package isi.devops.gestion_etablissement.controleur;

import isi.devops.gestion_etablissement.domaine.Classe;
import isi.devops.gestion_etablissement.service.ClasseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClasseController {

    private final ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    /**
     * Affiche la liste des classes
     */
    @GetMapping
    public String getAllClasses(Model model) {
        List<Classe> classes = classeService.getAllClasses();
        model.addAttribute("classes", classes);

        return "classes/getAllClasses";  // Fichier Thymeleaf : templates/classes/liste.html
    }

    /**
     * Affiche les détails d'une classe
     */
    @GetMapping("/{id}")
    public String getClasse(@PathVariable Long id, Model model) {
        Classe classe = classeService.getClasseById(id);
        model.addAttribute("classe", classe);
        return "classes/details";  // Fichier Thymeleaf : templates/classes/details.html
    }

    /**
     * Formulaire de création d'une classe
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "classes/createClasse";  // Fichier Thymeleaf : templates/classes/form.html
    }

    /**
     * Traitement du formulaire de création
     */
    @PostMapping
    public String createClasse(@ModelAttribute Classe classe) {
        classeService.createClasse(classe);
        return "redirect:/classes";
    }

    /**
     * Formulaire de modification
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Classe classe = classeService.getClasseById(id);
        model.addAttribute("classe", classe);
        return "classes/form";  // Réutilisation du même formulaire pour l'édition
    }

    /**
     * Traitement de la modification
     */
    @PostMapping("/{id}")
    public String updateClasse(@PathVariable Long id, @ModelAttribute Classe classe) {
        classeService.updateClasse(id, classe);
        return "redirect:/classes";
    }

    /**
     * Suppression d'une classe
     */
    @GetMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return "redirect:/classes";
    }
}
