package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.RequestAuditDTO;
import br.es.gov.cb.cbmesaudit.dtos.PagedAuditDTO;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/api/audits")
public class AuditController {

	private final AuditService auditService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody RequestAuditDTO requestAuditDTO) {
		auditService.create(requestAuditDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<PagedAuditDTO> findAll(
			Pageable pageable,
			@RequestParam(required = false) String auditedUser,
			@RequestParam(required = false) String sourceApp,
			@RequestParam(required = false) Date creationDate) {

		RequestAuditDTO requestAuditDTO = RequestAuditDTO.builder()
				.creationDate(creationDate)
				.auditedUser(auditedUser)
				.sourceApp(sourceApp)
				.build();

		return ResponseEntity.ok(auditService.findAll(pageable, requestAuditDTO));
	}
}
