package tn.souhaib.erp.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.souhaib.erp.dto.CommandeAchatRequest;
import tn.souhaib.erp.service.CommandeAchatService;

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
}
