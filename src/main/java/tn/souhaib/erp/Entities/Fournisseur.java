package tn.souhaib.erp.Entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String contact;
    private String qualite_service;
    private int note;
}
