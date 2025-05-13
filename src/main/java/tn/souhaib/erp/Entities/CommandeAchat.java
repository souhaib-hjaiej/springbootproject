package tn.souhaib.erp.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CommandeAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String statut;
    private double montant;

    @ManyToOne
    private Fournisseur fournisseur;
}
