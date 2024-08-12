package br.es.gov.cb.cbmesaudit.controllers;

import br.es.gov.cb.cbmesaudit.dtos.AuditFilterDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditPagedDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
			@RequestParam(required = false) List<String> auditedUsers,
			@RequestParam(required = false) List<String> sourceApps,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
		
		AuditFilterDTO auditFilterDTO = AuditFilterDTO.builder()
				.auditedUsers(auditedUsers)
				.sourceApps(sourceApps)
				.startDate(startDate)
				.endDate(endDate)
				.build();
		
		return ResponseEntity.ok(auditService.findAll(pageable, auditFilterDTO));
	}
}
