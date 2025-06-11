package tn.souhaib.erp.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.souhaib.erp.Entities.CommandeAchat;
import tn.souhaib.erp.Entities.LigneCommandeAchat;
import tn.souhaib.erp.dto.CommandeAchatDTO;
import tn.souhaib.erp.dto.CommandeAchatRequest;
import tn.souhaib.erp.service.CommandeAchatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/commandes")
public class CommandeAchatController {

    private final CommandeAchatService commandeAchatService;

    @PostMapping
    public ResponseEntity<String> createCommande(@RequestBody CommandeAchatRequest request) {
        commandeAchatService.createCommande(request);
        return ResponseEntity.ok("Commande ajoutée avec succès");
    }

    @GetMapping
    public ResponseEntity<List<LigneCommandeAchat>> getAllCommandes() {
        return ResponseEntity.ok(commandeAchatService.getAllLignes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeAchat> updateCommande(@PathVariable Long id, @RequestBody CommandeAchatDTO dto) {
        return ResponseEntity.ok(commandeAchatService.updateCommande(id, dto));
    }
}
