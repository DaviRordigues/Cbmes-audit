package br.es.gov.cb.cbmesaudit.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditPagedDTO {
    private List<AuditResponseDTO> audits;
    private int currentPage;
    private int totalPages;
    private long totalItems;
}
