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
    private String sourceApss;
    private String auditedUsers;
    private Date startDate;
    private Date endDate;
    private String description;
}
