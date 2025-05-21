package tn.souhaib.erp.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.souhaib.erp.Entities.HistoriqueAchats;
import tn.souhaib.erp.Repository.HistoriqueAchatsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/historiques")
@RequiredArgsConstructor
public class HistoriqueAchatsController {

    private final HistoriqueAchatsRepository historiqueAchatsRepository;

    
    @GetMapping
    public List<HistoriqueAchats> getAll() {
        return historiqueAchatsRepository.findAll();
    }

    
    @PatchMapping("/{id}/delai")
    public ResponseEntity<String> updateDelai(@PathVariable Long id, @RequestBody int newDelai) {
        HistoriqueAchats historique = historiqueAchatsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historique non trouvé"));

        historique.setDelai_livraison(newDelai);
        historiqueAchatsRepository.save(historique);

        return ResponseEntity.ok("Délai de livraison mis à jour");
    }
}
