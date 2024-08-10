package br.es.gov.cb.cbmesaudit.service;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    AuditDTO create(AuditDTO auditDTO);
    AuditDTO findById(Long id);
    Page<AuditDTO> findAll(Pageable pageable);
}
