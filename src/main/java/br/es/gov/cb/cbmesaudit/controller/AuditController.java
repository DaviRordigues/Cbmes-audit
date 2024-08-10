package br.es.gov.cb.cbmesaudit.controller;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import br.es.gov.cb.cbmesaudit.service.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/audits")
public class AuditController {
	
	private final AuditService auditService;
	
	/**
	 * Handles HTTP POST requests to create a new audit.
	 *
	 * @param auditDTO the audit data transfer object containing the details of the audit to be created
	 * @return a ResponseEntity containing the created AuditDTO
	 */
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody AuditDTO auditDTO) {
		auditService.create(auditDTO);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Handles HTTP GET requests to retrieve an audit by its ID.
	 *
	 * @param id the ID of the audit to be retrieved
	 * @return a ResponseEntity containing the AuditDTO of the requested audit
	 */
	@GetMapping("/{id}")
	public ResponseEntity<AuditDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(auditService.findById(id));
	}
	
	/**
	 * Handles HTTP GET requests to retrieve a paginated list of all audits.
	 *
	 * @return a ResponseEntity containing a Page of AuditDTOs
	 */
	@GetMapping
	public ResponseEntity<Page<AuditDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(auditService.findAll(pageable));
	}
}
