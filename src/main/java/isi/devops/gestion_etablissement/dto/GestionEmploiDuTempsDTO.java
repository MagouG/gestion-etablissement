package isi.devops.gestion_etablissement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GestionEmploiDuTempsDTO {
    private Long id;
    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
    private Long coursId;
    private Long classeId;
    private Long professeurId;
}
