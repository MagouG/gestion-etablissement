package isi.devops.gestion_etablissement.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateNaissance;
    private Long classeId;
}
