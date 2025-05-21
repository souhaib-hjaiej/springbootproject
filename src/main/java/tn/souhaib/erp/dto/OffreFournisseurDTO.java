package tn.souhaib.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OffreFournisseurDTO {
    private String fournisseur;
    private double prixMoyen;
    private double delaiMoyen;
    private String qualiteService;
    private double note;
}
