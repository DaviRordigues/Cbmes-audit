package br.es.gov.cb.cbmesaudit.services;

import br.es.gov.cb.cbmesaudit.dtos.AuditFilterDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    void create(AuditRequestDTO auditRequestDTO);
    Page<AuditResponseDTO> findAll(Pageable pageable, AuditFilterDTO auditFilterDTO);
}
