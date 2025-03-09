package isi.devops.gestion_etablissement.service;

import isi.devops.gestion_etablissement.domaine.GestionEmploiDuTemps;

import java.util.List;

public interface GestionEmploiDuTempsService {
    GestionEmploiDuTemps createEmploiDuTemps(GestionEmploiDuTemps emploi);
    GestionEmploiDuTemps getEmploiDuTempsById(Long id);
    List<GestionEmploiDuTemps> getAllEmploisDuTemps();
    GestionEmploiDuTemps updateEmploiDuTemps(Long id, GestionEmploiDuTemps emploi);
    void deleteEmploiDuTemps(Long id);
}
