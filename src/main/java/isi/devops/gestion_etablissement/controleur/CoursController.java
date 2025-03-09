package isi.devops.gestion_etablissement.controleur;

import isi.devops.gestion_etablissement.domaine.Classe;
import isi.devops.gestion_etablissement.domaine.Cours;
import isi.devops.gestion_etablissement.domaine.Professeur;
import isi.devops.gestion_etablissement.service.ClasseService;
import isi.devops.gestion_etablissement.service.CoursService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // Utilisation de @Controller au lieu de @RestController
@RequestMapping("/cours")  // Pas besoin de '/api' ici, on veut rendre des pages HTML
public class CoursController {

    private final CoursService coursService;
    private final ProfesseurController professeurController;
    private final ClasseService classeService;

    public CoursController(CoursService coursService, ProfesseurController professeurController, ClasseService classeService) {
        this.coursService = coursService;
        this.professeurController = professeurController;
        this.classeService = classeService;
    }

    @PostMapping()
    public String createCours(@ModelAttribute Cours cours) {
        coursService.createCours(cours);
        return "redirect:/cours";  // Redirige vers la page affichant tous les cours
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Classe> classes = classeService.getAllClasses();
        model.addAttribute("classes", classes);
        List<Professeur> professeurs = professeurController.getAllProfesseurs();
        model.addAttribute("professeurs", professeurs);
        model.addAttribute("cours",  new Cours());
        return "cours/createCours";  // Fichier Thymeleaf : templates/classes/form.html
    }
    @GetMapping("/edit/{id}")
    public String editCreateForm(@PathVariable Long id, Model model) {
        List<Classe> classes = classeService.getAllClasses();
        model.addAttribute("classes", classes);
        List<Professeur> professeurs = professeurController.getAllProfesseurs();
        model.addAttribute("professeurs", professeurs);
        Cours cours =  new Cours() ;
        model.addAttribute("cours", coursService.getCoursById (id));
        return "cours/createCours";  // Fichier Thymeleaf : templates/classes/form.html
    }

    @GetMapping("/{id}")
    public String getCours(@PathVariable Long id, Model model) {
        Cours cours = coursService.getCoursById(id);
        model.addAttribute("cours", cours);
        return "cours/detailCours";  // Page HTML spécifique pour afficher un cours
    }

    @GetMapping
    public String getAllCours(Model model) {
        List<Cours> cours = coursService.getAllCours();
        model.addAttribute("cours", cours);
        return "cours/getAllCours";  // Page HTML qui liste tous les cours
    }

    @PutMapping("/{id}")
    public String updateCours(@PathVariable Long id, @ModelAttribute Cours cours) {
        coursService.updateCours(id, cours);
        return "redirect:/cours";  // Redirige vers la page avec tous les cours après modification
    }

    @DeleteMapping("/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
        return "redirect:/cours";  // Redirige vers la page avec tous les cours après suppression
    }
}
