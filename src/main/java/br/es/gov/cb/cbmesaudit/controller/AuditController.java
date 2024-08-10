package br.es.gov.cb.cbmesaudit.controller;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import br.es.gov.cb.cbmesaudit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping
    public ResponseEntity<AuditDTO> createAudit(@RequestBody AuditDTO auditDTO) {
        return ResponseEntity.ok(auditService.createAudit(auditDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDTO> getAuditById(@PathVariable Long id) {
        return ResponseEntity.ok(auditService.getAuditById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        return ResponseEntity.ok(auditService.getAllAudits());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditDTO> updateAudit(@PathVariable Long id, @RequestBody AuditDTO auditDTO) {
        return ResponseEntity.ok(auditService.updateAudit(id, auditDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudit(@PathVariable Long id) {
        auditService.deleteAudit(id);
        return ResponseEntity.noContent().build();
    }
}
