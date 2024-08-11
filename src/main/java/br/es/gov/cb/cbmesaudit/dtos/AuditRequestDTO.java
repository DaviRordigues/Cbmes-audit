package br.es.gov.cb.cbmesaudit.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequestDTO {
    private String sourceApp;
    private String auditedUser;
    private Date startTime;
    private Date endTime;
    private String description;
}
