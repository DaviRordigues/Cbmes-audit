package br.es.gov.cb.cbmesaudit.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditFilterDTO {
    @NotNull(message = "Is not null")
    @NotEmpty(message = "Is not empty")
    private List<String> sourceApps;

    @NotNull(message = "Is not null")
    @NotEmpty(message = "Is not empty")
    private List<String> auditedUsers;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
