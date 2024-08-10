package br.es.gov.cb.cbmesaudit.services;

import br.es.gov.cb.cbmesaudit.dtos.AuditfilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    void create(AuditfilterDTO auditfilterDTO);
    Page<AuditfilterDTO> findAll(Pageable pageable, AuditfilterDTO AuditfilterDTO);
}
