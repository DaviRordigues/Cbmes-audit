package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.AuditfilterDTO;
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
	public ResponseEntity<Void> create(@RequestBody AuditfilterDTO auditfilterDTO) {
		auditService.create(auditfilterDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Page<AuditfilterDTO>> findAll(Pageable pageable, AuditfilterDTO AuditfilterDTO) {
		return ResponseEntity.ok(auditService.findAll(pageable, AuditfilterDTO));
	}
}
