package isi.devops.gestion_etablissement.dto;

import lombok.Data;
import java.util.List;

@Data
public class ClasseDTO {
    private Long id;
    private String nom;
    private String niveau;
    private String anneeScolaire;
    private List<Long> etudiantsIds;
    private List<Long> coursIds;
}
