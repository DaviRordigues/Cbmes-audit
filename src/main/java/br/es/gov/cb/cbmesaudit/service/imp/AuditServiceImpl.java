package br.es.gov.cb.cbmesaudit.service.imp;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import br.es.gov.cb.cbmesaudit.entity.AuditEntity;
import br.es.gov.cb.cbmesaudit.repository.AuditRepository;
import br.es.gov.cb.cbmesaudit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Override
    @Async
    public AuditDTO create(AuditDTO auditDTO) {
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setSourceApp(auditDTO.getSourceApp());
        auditEntity.setCreationDate(auditDTO.getCreationDate());
        auditEntity.setAuditedUser(auditDTO.getAuditedUser());
        auditEntity.setDescription(auditDTO.getDescription());

        auditEntity = auditRepository.save(auditEntity);
        auditDTO.setId(auditEntity.getId());
        return auditDTO;
    }

    @Override
    public AuditDTO findById(Long id) {
        return auditRepository.findById(id)
                .map(auditEntity -> {
                    AuditDTO auditDTO = new AuditDTO();
                    auditDTO.setId(auditEntity.getId());
                    auditDTO.setSourceApp(auditEntity.getSourceApp());
                    auditDTO.setCreationDate(auditEntity.getCreationDate());
                    auditDTO.setAuditedUser(auditEntity.getAuditedUser());
                    auditDTO.setDescription(auditEntity.getDescription());
                    return auditDTO;
                }).orElse(null);
    }

    @Override
    public Page<AuditDTO> findAll(Pageable pageable) {
        return auditRepository.findAll(pageable)
                .map(auditEntity -> {
                    AuditDTO auditDTO = new AuditDTO();
                    auditDTO.setId(auditEntity.getId());
                    auditDTO.setSourceApp(auditEntity.getSourceApp());
                    auditDTO.setCreationDate(auditEntity.getCreationDate());
                    auditDTO.setAuditedUser(auditEntity.getAuditedUser());
                    auditDTO.setDescription(auditEntity.getDescription());
                    return auditDTO;
                });
    }
}
