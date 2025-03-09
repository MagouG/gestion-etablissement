package isi.devops.gestion_etablissement.repository;
import isi.devops.gestion_etablissement.domaine.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}