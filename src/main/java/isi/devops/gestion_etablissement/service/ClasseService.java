package isi.devops.gestion_etablissement.service;
import isi.devops.gestion_etablissement.domaine.Classe;

import java.util.List;

public interface ClasseService {
    Classe createClasse(Classe classe);
    Classe getClasseById(Long id);
    List<Classe> getAllClasses();
    Classe updateClasse(Long id, Classe classe);
    void deleteClasse(Long id);
}