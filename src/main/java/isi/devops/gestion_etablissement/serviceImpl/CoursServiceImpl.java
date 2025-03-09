package isi.devops.gestion_etablissement.serviceImpl;
import isi.devops.gestion_etablissement.domaine.Cours;
import isi.devops.gestion_etablissement.repository.CoursRepository;
import isi.devops.gestion_etablissement.service.ClasseService;
import isi.devops.gestion_etablissement.service.CoursService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursServiceImpl implements CoursService {

    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public Cours createCours(Cours classe) {
        return coursRepository.save(classe);
    }

    @Override
    public Cours getCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours updateCours(Long id, Cours classe) {
        if (coursRepository.existsById(id)) {
            classe.setId(id);
            return coursRepository.save(classe);
        }
        return null;
    }

    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}