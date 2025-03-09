package isi.devops.gestion_etablissement.serviceImpl;
import isi.devops.gestion_etablissement.domaine.GestionEmploiDuTemps;
import isi.devops.gestion_etablissement.repository.GestionEmploiDuTempsRepository;
import isi.devops.gestion_etablissement.service.CoursService;
import isi.devops.gestion_etablissement.service.GestionEmploiDuTempsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionEmploiDuTempsServiceImpl implements GestionEmploiDuTempsService {

    private final GestionEmploiDuTempsRepository gestionEmploiDuTempsRepository;

    public GestionEmploiDuTempsServiceImpl(GestionEmploiDuTempsRepository gestionEmploiDuTempsRepository) {
        this.gestionEmploiDuTempsRepository = gestionEmploiDuTempsRepository;
    }

    @Override
    public GestionEmploiDuTemps createEmploiDuTemps(GestionEmploiDuTemps classe) {
        return gestionEmploiDuTempsRepository.save(classe);
    }

    @Override
    public GestionEmploiDuTemps getEmploiDuTempsById(Long id) {
        return gestionEmploiDuTempsRepository.findById(id).orElse(null);
    }

    @Override
    public List<GestionEmploiDuTemps> getAllEmploisDuTemps() {
        return gestionEmploiDuTempsRepository.findAll();
    }

    @Override
    public GestionEmploiDuTemps updateEmploiDuTemps(Long id, GestionEmploiDuTemps classe) {
        if (gestionEmploiDuTempsRepository.existsById(id)) {
            classe.setId(id);
            return gestionEmploiDuTempsRepository.save(classe);
        }
        return null;
    }

    @Override
    public void deleteEmploiDuTemps(Long id) {
        gestionEmploiDuTempsRepository.deleteById(id);
    }
}