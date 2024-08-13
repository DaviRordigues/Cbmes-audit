package br.es.gov.cb.auditapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponseDTO {
    private Long id;
    private String sourceApp;
    private String auditedUser;
    private String description;
}
