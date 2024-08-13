package br.es.gov.cb.auditapp.services;

import br.es.gov.cb.auditapp.dtos.AuditFilterDTO;
import br.es.gov.cb.auditapp.dtos.AuditRequestDTO;
import br.es.gov.cb.auditapp.dtos.AuditResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    void create(AuditRequestDTO auditRequestDTO);
    Page<AuditResponseDTO> findAll(Pageable pageable, AuditFilterDTO auditFilterDTO);
}
