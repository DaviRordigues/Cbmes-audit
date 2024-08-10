package br.es.gov.cb.cbmesaudit.services;

import br.es.gov.cb.cbmesaudit.dtos.AuditDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    void create(AuditDTO auditDTO);
    Page<AuditDTO> findAll(Pageable pageable, AuditDTO filter);
}
