package br.es.gov.cb.cbmesaudit.service;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;

import java.util.List;

public interface AuditService {
    AuditDTO createAudit(AuditDTO auditDTO);
    AuditDTO getAuditById(Long id);
    List<AuditDTO> getAllAudits();
    AuditDTO updateAudit(Long id, AuditDTO auditDTO);
    void deleteAudit(Long id);
}
