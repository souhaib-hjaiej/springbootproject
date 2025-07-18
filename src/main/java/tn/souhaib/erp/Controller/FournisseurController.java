package tn.souhaib.erp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.souhaib.erp.Entities.Fournisseur;
import tn.souhaib.erp.Repository.FournisseurRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fournisseurs")
@CrossOrigin(origins = "*")
public class FournisseurController {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    // GET all
    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return fournisseur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST create
    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    // PATCH update partial
    @PatchMapping("/{id}")
    public ResponseEntity<Fournisseur> patchFournisseur(@PathVariable Long id, @RequestBody Fournisseur updatedFournisseur) {
        return fournisseurRepository.findById(id).map(f -> {
            if (updatedFournisseur.getNom() != null) {
                f.setNom(updatedFournisseur.getNom());
            }
            if (updatedFournisseur.getContact() != null) {
                f.setContact(updatedFournisseur.getContact());
            }
            if (updatedFournisseur.getQualite_service() != null) {
                f.setQualite_service(updatedFournisseur.getQualite_service());
            }
            if (updatedFournisseur.getNote() != 0) {
                f.setNote(updatedFournisseur.getNote());
            }
            fournisseurRepository.save(f);
            return ResponseEntity.ok(f);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        if (!fournisseurRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fournisseurRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // SEARCH by nom
    @GetMapping("/search/nom/{nom}")
    public List<Fournisseur> searchByNom(@PathVariable String nom) {
        return fournisseurRepository.findByNomContainingIgnoreCase(nom);
    }

    // SEARCH by contact
    @GetMapping("/search/contact/{contact}")
    public List<Fournisseur> searchByContact(@PathVariable String contact) {
        return fournisseurRepository.findByContactContainingIgnoreCase(contact);
    }

    // SEARCH by note
    @GetMapping("/search/note/{note}")
    public List<Fournisseur> searchByNote(@PathVariable int note) {
        return fournisseurRepository.findByNote(note);
    }
}
