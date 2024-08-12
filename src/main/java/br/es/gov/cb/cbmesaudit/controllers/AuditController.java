package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditPagedDTO;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

	@GetMapping
	public ResponseEntity<AuditPagedDTO> findAll(
			Pageable pageable,
			@RequestParam(required = false) String auditedUsers,
			@RequestParam(required = false) String sourceApss,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

		AuditRequestDTO auditRequestDTO = AuditRequestDTO.builder()
				.auditedUsers(auditedUsers)
				.sourceApss(sourceApss)
				.startDate(startDate)
				.endDate(endDate)
				.build();

		return ResponseEntity.ok(auditService.findAll(pageable, auditRequestDTO));
	}
}
