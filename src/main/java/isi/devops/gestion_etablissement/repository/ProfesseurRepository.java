package isi.devops.gestion_etablissement.repository;

import isi.devops.gestion_etablissement.domaine.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
