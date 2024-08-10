package br.es.gov.cb.cbmesaudit.controller;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import br.es.gov.cb.cbmesaudit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping
    public ResponseEntity<AuditDTO> create(@RequestBody AuditDTO auditDTO) {
        return ResponseEntity.ok(auditService.create(auditDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(auditService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<AuditDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(auditService.findAll(pageable));
    }
}
