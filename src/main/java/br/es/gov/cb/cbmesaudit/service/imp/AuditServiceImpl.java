package br.es.gov.cb.cbmesaudit.service.imp;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import br.es.gov.cb.cbmesaudit.entity.Audit;
import br.es.gov.cb.cbmesaudit.repository.AuditRepository;
import br.es.gov.cb.cbmesaudit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Override
    public AuditDTO createAudit(AuditDTO auditDTO) {
        Audit audit = new Audit();
        audit.setSourceApp(auditDTO.getSourceApp());
        audit.setCreationDate(auditDTO.getCreationDate());
        audit.setAuditedUser(auditDTO.getAuditedUser());
        audit.setDescription(auditDTO.getDescription());

        audit = auditRepository.save(audit);
        auditDTO.setId(audit.getId());
        return auditDTO;
    }

    @Override
    public AuditDTO getAuditById(Long id) {
        return auditRepository.findById(id)
                .map(audit -> {
                    AuditDTO auditDTO = new AuditDTO();
                    auditDTO.setId(audit.getId());
                    auditDTO.setSourceApp(audit.getSourceApp());
                    auditDTO.setCreationDate(audit.getCreationDate());
                    auditDTO.setAuditedUser(audit.getAuditedUser());
                    auditDTO.setDescription(audit.getDescription());
                    return auditDTO;
                }).orElse(null);
    }

    @Override
    public List<AuditDTO> getAllAudits() {
        return auditRepository.findAll()
                .stream()
                .map(audit -> {
                    AuditDTO auditDTO = new AuditDTO();
                    auditDTO.setId(audit.getId());
                    auditDTO.setSourceApp(audit.getSourceApp());
                    auditDTO.setCreationDate(audit.getCreationDate());
                    auditDTO.setAuditedUser(audit.getAuditedUser());
                    auditDTO.setDescription(audit.getDescription());
                    return auditDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public AuditDTO updateAudit(Long id, AuditDTO auditDTO) {
        return auditRepository.findById(id)
                .map(audit -> {
                    audit.setSourceApp(auditDTO.getSourceApp());
                    audit.setCreationDate(auditDTO.getCreationDate());
                    audit.setAuditedUser(auditDTO.getAuditedUser());
                    audit.setDescription(auditDTO.getDescription());
                    auditRepository.save(audit);
                    auditDTO.setId(audit.getId());
                    return auditDTO;
                }).orElse(null);
    }

    @Override
    public void deleteAudit(Long id) {
        auditRepository.deleteById(id);
    }
}
