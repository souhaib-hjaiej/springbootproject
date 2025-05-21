package tn.souhaib.erp.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.souhaib.erp.Repository.LigneCommandeRepository;
import tn.souhaib.erp.dto.OffreFournisseurDTO;

import java.util.List;

@RestController
@RequestMapping("/api/comparaison")
@RequiredArgsConstructor
public class ComparaisonController {

    private final LigneCommandeRepository LigneCommandeRepository;

    @GetMapping("/produit")
    public List<OffreFournisseurDTO> getComparaison(@RequestParam String produit) {
        return LigneCommandeRepository.findComparaisonOffresByProduit(produit);
    }
}
