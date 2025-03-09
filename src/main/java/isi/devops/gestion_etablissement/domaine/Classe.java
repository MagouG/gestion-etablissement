package isi.devops.gestion_etablissement.domaine;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String niveau;
    private String anneeScolaire;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Cours> cours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
