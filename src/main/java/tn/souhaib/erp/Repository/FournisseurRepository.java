package tn.souhaib.erp.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.souhaib.erp.Entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findByNomContainingIgnoreCase(String nom);
    List<Fournisseur> findByContactContainingIgnoreCase(String contact);
    List<Fournisseur> findByNote(int note);
}
