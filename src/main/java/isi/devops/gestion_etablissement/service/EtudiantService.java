package isi.devops.gestion_etablissement.service;

import isi.devops.gestion_etablissement.domaine.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
    Etudiant updateEtudiant(Long id, Etudiant etudiant);
    void deleteEtudiant(Long id);
}
