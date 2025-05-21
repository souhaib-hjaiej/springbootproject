package tn.souhaib.erp.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.souhaib.erp.Entities.CommandeAchat;
import tn.souhaib.erp.Entities.Fournisseur;
import tn.souhaib.erp.Entities.HistoriqueAchats;
import tn.souhaib.erp.Entities.LigneCommandeAchat;
import tn.souhaib.erp.Repository.CommandeAchatRepository;
import tn.souhaib.erp.Repository.FournisseurRepository;
import tn.souhaib.erp.Repository.HistoriqueAchatsRepository;
import tn.souhaib.erp.Repository.LigneCommandeAchatRepository;
import tn.souhaib.erp.dto.CommandeAchatRequest;

@Service
@RequiredArgsConstructor
public class CommandeAchatService {

    private final CommandeAchatRepository commandeAchatRepository;
    private final LigneCommandeAchatRepository ligneCommandeAchatRepository;
    private final FournisseurRepository fournisseurRepository;
    private final HistoriqueAchatsRepository historiqueAchatsRepository;


    public void createCommande(CommandeAchatRequest request) {
        Fournisseur fournisseur = fournisseurRepository.findById(request.getFournisseurId())
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));

        
        double montant = request.getLignes().stream()
                .mapToDouble(ligne -> ligne.getPrix_unitaire() * ligne.getQuantite())
                .sum();

       
        CommandeAchat commande = new CommandeAchat();
        commande.setDate(request.getDate());
        commande.setStatut(request.getStatut());
        commande.setMontant(montant);
        commande.setFournisseur(fournisseur);

        CommandeAchat savedCommande = commandeAchatRepository.save(commande);

        
        for (CommandeAchatRequest.LigneRequest ligneRequest : request.getLignes()) {
            LigneCommandeAchat ligne = new LigneCommandeAchat();
            ligne.setProduit(ligneRequest.getProduit());
            ligne.setQuantite(ligneRequest.getQuantite());
            ligne.setPrix_unitaire(ligneRequest.getPrix_unitaire());
            ligne.setCommande(savedCommande);

            ligneCommandeAchatRepository.save(ligne);
            
            HistoriqueAchats historique = new HistoriqueAchats();
            historique.setProduit(ligneRequest.getProduit());
            historique.setQuantite(ligneRequest.getQuantite());
            historique.setDelai_livraison(0); 
            historique.setFournisseur(fournisseur);
            historiqueAchatsRepository.save(historique); 
        }
    }
}

