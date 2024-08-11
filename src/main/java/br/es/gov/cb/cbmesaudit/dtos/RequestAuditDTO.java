package br.es.gov.cb.cbmesaudit.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAuditDTO {
    private String sourceApp;
    private String auditedUser;
    private String description;
    private Date creationDate;
}
