package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.AuditDTO;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/audits")
public class AuditController {
	
	private final AuditService auditService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody AuditDTO auditDTO) {
		auditService.create(auditDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Page<AuditDTO>> findAll(Pageable pageable, AuditDTO filter) {
		return ResponseEntity.ok(auditService.findAll(pageable, filter));
	}
}
