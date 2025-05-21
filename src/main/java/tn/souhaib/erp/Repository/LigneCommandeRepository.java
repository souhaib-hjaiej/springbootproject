package tn.souhaib.erp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.souhaib.erp.Entities.LigneCommandeAchat;
import tn.souhaib.erp.dto.OffreFournisseurDTO;

@Repository
public interface LigneCommandeRepository extends CrudRepository<LigneCommandeAchat, Long> {

    @Query("SELECT new tn.souhaib.erp.dto.OffreFournisseurDTO(" +
           "f.nom, " +
           "AVG(l.prix_unitaire), " +
           "(SELECT AVG(h.delai_livraison) FROM HistoriqueAchats h WHERE h.produit = l.produit AND h.fournisseur = f), " +
           "f.qualite_service, " +
           "f.note) " +
           "FROM LigneCommandeAchat l " +
           "JOIN l.commande c " +
           "JOIN c.fournisseur f " +
           "WHERE l.produit = :produit " +
           "GROUP BY f.id")
    List<OffreFournisseurDTO> findComparaisonOffresByProduit(@Param("produit") String produit);
}
