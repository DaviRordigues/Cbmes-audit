package br.es.gov.cb.cbmesaudit.mapper;

import br.es.gov.cb.cbmesaudit.dtos.RequestAuditDTO;
import br.es.gov.cb.cbmesaudit.dtos.ResponseAuditDTO;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;

public class AuditMapper {

    public static AuditEntity createAuditEntityFromDTO(RequestAuditDTO requestAuditDTO) {
        return AuditEntity.builder()
                .sourceApp(requestAuditDTO.getSourceApp())
                .auditedUser(requestAuditDTO.getAuditedUser())
                .description(requestAuditDTO.getDescription())
                .build();
    }

    public static ResponseAuditDTO createAuditDTOFromEntity(AuditEntity auditEntity) {
        return ResponseAuditDTO.builder()
                .id(auditEntity.getId())
                .sourceApp(auditEntity.getSourceApp())
                .auditedUser(auditEntity.getAuditedUser())
                .description(auditEntity.getDescription())
                .creationDate(auditEntity.getCreationDate())
                .build();
    }
}
