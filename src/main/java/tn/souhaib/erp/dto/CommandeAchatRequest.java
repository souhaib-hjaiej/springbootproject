package tn.souhaib.erp.dto;
import lombok.Data;
import java.util.List;

@Data
public class CommandeAchatRequest {
    private String date;
    private String statut;
    private Long fournisseurId;

    private List<LigneRequest> lignes;

    @Data
    public static class LigneRequest {
        private String produit;
        private int quantite;
        private double prix_unitaire;
    }
}

