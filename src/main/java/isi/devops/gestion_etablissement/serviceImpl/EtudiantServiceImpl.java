package isi.devops.gestion_etablissement.serviceImpl;
import isi.devops.gestion_etablissement.domaine.Etudiant;
import isi.devops.gestion_etablissement.repository.EtudiantRepository;
import isi.devops.gestion_etablissement.service.CoursService;
import isi.devops.gestion_etablissement.service.EtudiantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant createEtudiant(Etudiant classe) {
        return etudiantRepository.save(classe);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant classe) {
        if (etudiantRepository.existsById(id)) {
            classe.setId(id);
            return etudiantRepository.save(classe);
        }
        return null;
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}