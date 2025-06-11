package tn.souhaib.erp.dto;

import lombok.Data;

@Data
public class CommandeAchatDTO {
    private Long id;
    private String date;
    private String statut;
    private double montant;
    private Long fournisseurId;
}
