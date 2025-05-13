package tn.souhaib.erp.Entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LigneCommandeAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produit;
    private int quantite;
    private double prix_unitaire;

    @ManyToOne
    private CommandeAchat commande;
}
