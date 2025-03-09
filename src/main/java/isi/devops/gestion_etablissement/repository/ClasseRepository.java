package isi.devops.gestion_etablissement.repository;

import isi.devops.gestion_etablissement.domaine.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {


}