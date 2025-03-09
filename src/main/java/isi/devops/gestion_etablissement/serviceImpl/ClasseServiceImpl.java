package isi.devops.gestion_etablissement.serviceImpl;
import isi.devops.gestion_etablissement.domaine.Classe;
import isi.devops.gestion_etablissement.repository.ClasseRepository;
import isi.devops.gestion_etablissement.service.ClasseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public Classe createClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public Classe getClasseById(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @Override
    public Classe updateClasse(Long id, Classe classe) {
        if (classeRepository.existsById(id)) {
            classe.setId(id);
            return classeRepository.save(classe);
        }
        return null;
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}