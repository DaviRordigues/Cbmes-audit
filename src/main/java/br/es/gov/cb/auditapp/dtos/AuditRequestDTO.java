package br.es.gov.cb.auditapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequestDTO {
	@NotNull(message = "Is not null")
	@NotEmpty(message = "Is not empty")
	private String sourceApp;
	
	@NotNull(message = "Is not null")
	@NotEmpty(message = "Is not empty")
	private String auditedUser;
	
	private String description;
}
