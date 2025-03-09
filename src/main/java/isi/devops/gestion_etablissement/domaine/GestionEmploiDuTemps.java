package isi.devops.gestion_etablissement.domaine;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionEmploiDuTemps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public LocalDateTime getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(LocalDateTime dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }
}
