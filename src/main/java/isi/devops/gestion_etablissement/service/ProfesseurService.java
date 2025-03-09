package isi.devops.gestion_etablissement.service;

import isi.devops.gestion_etablissement.domaine.Professeur;

import java.util.List;

public interface ProfesseurService {
    Professeur createProfesseur(Professeur professeur);
    Professeur getProfesseurById(Long id);
    List<Professeur> getAllProfesseurs();
    Professeur updateProfesseur(Long id, Professeur professeur);
    void deleteProfesseur(Long id);
}
