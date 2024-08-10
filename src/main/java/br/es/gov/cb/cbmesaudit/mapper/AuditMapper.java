package br.es.gov.cb.cbmesaudit.mapper;

import br.es.gov.cb.cbmesaudit.dtos.AuditfilterDTO;
import br.es.gov.cb.cbmesaudit.entitys.AuditEntity;

public class AuditMapper {
    //TODO: CRIEI A CLASSE
    public static AuditEntity createAuditEntityFromDTO(AuditfilterDTO auditfilterDTO) {
        return AuditEntity.builder()
                .sourceApp(auditfilterDTO.getSourceApp())
                .auditedUser(auditfilterDTO.getAuditedUser())
                .description(auditfilterDTO.getDescription())
                .build();
    }

    public static AuditfilterDTO createAuditDTOFromEntity(AuditEntity auditEntity) {
        return AuditfilterDTO.builder()
                .id(auditEntity.getId())
                .sourceApp(auditEntity.getSourceApp())
                .auditedUser(auditEntity.getAuditedUser())
                .description(auditEntity.getDescription())
                .build();
    }
}
