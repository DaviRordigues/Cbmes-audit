package br.es.gov.cb.cbmesaudit.services.imps;

import br.es.gov.cb.cbmesaudit.dtos.AuditDTO;
import br.es.gov.cb.cbmesaudit.entitys.AuditEntity;
import br.es.gov.cb.cbmesaudit.repositorys.AuditRepository;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Example;
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

	@Override
	//TODO: AuditDTO e filter SÃO AS MESMAS COISAS? PORQUE NAO USAR O MESMO NOME? O NOME AUDITDTO NÃO É REPRESENTA O QUE ELE PRETENDE FAZER?
	//TODO: FILTER DE QUE? O NOME NÃO É MUITO CLARO.
	public Page<AuditDTO> findAll(Pageable pageable, AuditDTO filter) {
		AuditEntity exampleEntity = createAuditEntityFromDTO(filter);

		//TODO: ESSA PARECE UMA ABORDAGEM INTERESSANTE, MAS NÃO ATENDE AO RANGE DA DATAS.
		Example<AuditEntity> example = Example.of(exampleEntity);
		return auditRepository.findAll(example, pageable)
				.map(this::createAuditDTOFromEntity);
	}

	//TODO: VAMOS MOVER ESSE MÉTODO PARA OUTRO LOCAL. VAMOS CRIAR UMA CLASSE CHAMADA AuditMapper E COLOCAR ELA DENTRO DE UM PACOTE CHAMADO mappers
	private AuditEntity createAuditEntityFromDTO(AuditDTO auditDTO) {
		return AuditEntity.builder()
				.sourceApp(auditDTO.getSourceApp())
				.creationDate(auditDTO.getCreationDate())
				.auditedUser(auditDTO.getAuditedUser())
				.description(auditDTO.getDescription())
				.build();
	}
	//TODO: VAMOS MOVER ESSE MÉTODO PARA OUTRO LOCAL. VAMOS CRIAR UMA CLASSE CHAMADA AuditMapper E COLOCAR ELA DENTRO DE UM PACOTE CHAMADO mappers
	private AuditDTO createAuditDTOFromEntity(AuditEntity auditEntity) {
		return AuditDTO.builder()
				.id(auditEntity.getId())
				.sourceApp(auditEntity.getSourceApp())
				.creationDate(auditEntity.getCreationDate())
				.auditedUser(auditEntity.getAuditedUser())
				.description(auditEntity.getDescription())
				.build();
	}
}
