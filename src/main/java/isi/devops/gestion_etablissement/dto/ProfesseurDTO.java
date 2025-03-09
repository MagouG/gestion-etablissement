package isi.devops.gestion_etablissement.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProfesseurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;
    private List<Long> coursIds;
}
