package br.es.gov.cb.cbmesaudit.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditfilterDTO {
	private Long id;
	private String sourceApp;
	private String auditedUser;
	private String description;
	@JsonIgnore
	private LocalDateTime startDate;
	@JsonIgnore
	private LocalDateTime endDate;
}
