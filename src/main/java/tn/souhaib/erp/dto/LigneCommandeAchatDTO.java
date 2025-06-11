package tn.souhaib.erp.dto;

import lombok.Data;

@Data
public class LigneCommandeAchatDTO {
    private Long id;
    private String produit;
    private int quantite;
    private double prix_unitaire;
    private Long commandeId;
}
