package br.es.gov.cb.auditapp.controllers;

import br.es.gov.cb.auditapp.dtos.AuditFilterDTO;
import br.es.gov.cb.auditapp.dtos.AuditRequestDTO;
import br.es.gov.cb.auditapp.dtos.AuditResponseDTO;
import br.es.gov.cb.auditapp.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Void> create(@RequestBody AuditRequestDTO auditRequestDTO) {
		auditService.create(auditRequestDTO);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/search")
	public ResponseEntity<Page<AuditResponseDTO>> findAll(
			@RequestBody AuditFilterDTO auditFilterDTO,
			Pageable pageable) {

		return ResponseEntity.ok(auditService.findAll(pageable, auditFilterDTO));
	}

}
