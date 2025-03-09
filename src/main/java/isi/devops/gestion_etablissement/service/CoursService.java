package isi.devops.gestion_etablissement.service;
import isi.devops.gestion_etablissement.domaine.Cours;

import java.util.List;

public interface CoursService {
    Cours createCours(Cours cours);
    Cours getCoursById(Long id);
    List<Cours> getAllCours();
    Cours updateCours(Long id, Cours cours);
    void deleteCours(Long id);
}