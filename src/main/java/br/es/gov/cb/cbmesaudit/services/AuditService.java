package br.es.gov.cb.cbmesaudit.services;

import br.es.gov.cb.cbmesaudit.dtos.RequestAuditDTO;
import br.es.gov.cb.cbmesaudit.dtos.PagedAuditDTO;
import org.springframework.data.domain.Pageable;

public interface AuditService {
    void create(RequestAuditDTO requestAuditDTO);
    PagedAuditDTO findAll(Pageable pageable, RequestAuditDTO requestAuditDTO);
}
