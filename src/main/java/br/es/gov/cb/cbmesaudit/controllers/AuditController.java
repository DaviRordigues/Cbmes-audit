package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditPagedDTO;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
			@RequestParam(required = false) String sourceApps,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startTime,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endTime) {

		AuditRequestDTO auditRequestDTO = AuditRequestDTO.builder()
				.auditedUser(auditedUsers)
				.sourceApp(sourceApps)
				.startTime(startTime)
				.endTime(endTime)
				.build();

		return ResponseEntity.ok(auditService.findAll(pageable, auditRequestDTO));
	}
}
