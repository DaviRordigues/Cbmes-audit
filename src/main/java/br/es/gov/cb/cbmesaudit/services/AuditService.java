package br.es.gov.cb.cbmesaudit.services;

import br.es.gov.cb.cbmesaudit.dtos.AuditFilterDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditPagedDTO;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    void create(AuditRequestDTO auditRequestDTO);
    AuditPagedDTO findAll(Pageable pageable, AuditFilterDTO auditFilterDTO);
}
