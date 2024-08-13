package br.es.gov.cb.auditapp.mapper;

import br.es.gov.cb.auditapp.dtos.AuditRequestDTO;
import br.es.gov.cb.auditapp.dtos.AuditResponseDTO;
import br.es.gov.cb.auditapp.entities.AuditEntity;

public class AuditMapper {
	private AuditMapper() {
		super();
	}
	
	public static AuditEntity createAuditEntityFromDTO(AuditRequestDTO auditRequestDTO) {
		return AuditEntity.builder()
				.sourceApp(auditRequestDTO.getSourceApp())
				.auditedUser(auditRequestDTO.getAuditedUser())
				.description(auditRequestDTO.getDescription())
				.build();
	}
	
	public static AuditResponseDTO createAuditDTOFromEntity(AuditEntity auditEntity) {
		return AuditResponseDTO.builder()
				.id(auditEntity.getId())
				.sourceApp(auditEntity.getSourceApp())
				.auditedUser(auditEntity.getAuditedUser())
				.description(auditEntity.getDescription())
				.build();
	}
}
