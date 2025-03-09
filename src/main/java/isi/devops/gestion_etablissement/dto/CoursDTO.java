package isi.devops.gestion_etablissement.dto;

import lombok.Data;

@Data
public class CoursDTO {
    private Long id;
    private String nom;
    private String description;
    private Long professeurId;
    private Long classeId;
}
