package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.AuditfilterDTO;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
	public ResponseEntity<Page<AuditfilterDTO>> findAll(
			Pageable pageable,
			@RequestParam(required = false) LocalDateTime startDate,
			@RequestParam(required = false) LocalDateTime endDate,
			@RequestParam(required = false) String auditedUser,
			@RequestParam(required = false) String sourceApp) {

		AuditfilterDTO filterDTO = new AuditfilterDTO();
		filterDTO.setStartDate(startDate);
		filterDTO.setEndDate(endDate);
		filterDTO.setAuditedUser(auditedUser);
		filterDTO.setSourceApp(sourceApp);

		return ResponseEntity.ok(auditService.findAll(pageable, filterDTO));
	}
}
