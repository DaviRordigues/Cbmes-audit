package br.es.gov.cb.cbmesaudit.service.imp;

import br.es.gov.cb.cbmesaudit.dto.AuditDTO;
import br.es.gov.cb.cbmesaudit.entity.AuditEntity;
import br.es.gov.cb.cbmesaudit.repository.AuditRepository;
import br.es.gov.cb.cbmesaudit.service.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {
	
	private final AuditRepository auditRepository;
	
	@Override
	@Async
	public void create(AuditDTO auditDTO) {
		auditRepository.save(createAuditEntityFromDTO(auditDTO));
	}
	
	//TODO: NÃO PRECISAMOS DE UMA BUSCA PELO ID
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
	
	//TODO: AINDA NAO ESTA FILTRANDO PELOS ATRIBUTOS NECESSARIOS
	@Override
	public Page<AuditDTO> findAll(Pageable pageable) {
		return auditRepository.findAll(pageable)
				.map(auditEntity -> {
					//TODO: EVITE O USO DE INSTANCIAÇÃO DIRETA DE OBJETOS, USE O BUILDER
					AuditDTO auditDTO = new AuditDTO();
					auditDTO.setId(auditEntity.getId());
					auditDTO.setSourceApp(auditEntity.getSourceApp());
					auditDTO.setCreationDate(auditEntity.getCreationDate());
					auditDTO.setAuditedUser(auditEntity.getAuditedUser());
					auditDTO.setDescription(auditEntity.getDescription());
					return auditDTO;
				});
	}
	
	private AuditEntity createAuditEntityFromDTO(AuditDTO auditDTO) {
		return AuditEntity.builder()
				.sourceApp(auditDTO.getSourceApp())
				.creationDate(auditDTO.getCreationDate())
				.auditedUser(auditDTO.getAuditedUser())
				.description(auditDTO.getDescription())
				.build();
	}
	
}
