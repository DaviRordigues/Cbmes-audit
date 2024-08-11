package br.es.gov.cb.cbmesaudit.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagedAuditDTO {
    private List<ResponseAuditDTO> audits;
    private int currentPage;
    private int totalPages;
    private long totalItems;
}
