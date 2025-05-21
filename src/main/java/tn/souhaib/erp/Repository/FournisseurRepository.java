package tn.souhaib.erp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.souhaib.erp.Entities.Fournisseur;
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
