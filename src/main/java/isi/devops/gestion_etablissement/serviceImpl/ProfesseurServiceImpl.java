package isi.devops.gestion_etablissement.serviceImpl;
import isi.devops.gestion_etablissement.domaine.Professeur;
import isi.devops.gestion_etablissement.domaine.Professeur;
import isi.devops.gestion_etablissement.repository.ProfesseurRepository;
import isi.devops.gestion_etablissement.service.ClasseService;
import isi.devops.gestion_etablissement.service.ProfesseurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurRepository professeurRepository;

    public ProfesseurServiceImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    @Override
    public Professeur createProfesseur(Professeur classe) {
        return professeurRepository.save(classe);
    }

    @Override
    public Professeur getProfesseurById(Long id) {
        return professeurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    @Override
    public Professeur updateProfesseur(Long id, Professeur classe) {
        if (professeurRepository.existsById(id)) {
            classe.setId(id);
            return professeurRepository.save(classe);
        }
        return null;
    }

    @Override
    public void deleteProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }
}