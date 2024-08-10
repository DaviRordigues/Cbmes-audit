package br.es.gov.cb.cbmesaudit.services.imps;

import br.es.gov.cb.cbmesaudit.dtos.AuditfilterDTO;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;
import br.es.gov.cb.cbmesaudit.mapper.AuditMapper;
import br.es.gov.cb.cbmesaudit.repositorys.AuditRepository;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import br.es.gov.cb.cbmesaudit.specification.AuditSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {

	private final AuditRepository auditRepository;

	@Override
	@Async
	public void create(AuditfilterDTO auditfilterDTO) {
		auditRepository.save(AuditMapper.createAuditEntityFromDTO(auditfilterDTO));
	}

	@Override
	//TODO: AuditDTO e filter SÃO AS MESMAS COISAS? PORQUE NAO USAR O MESMO NOME? O NOME AUDITDTO NÃO É REPRESENTA O QUE ELE PRETENDE FAZER?xxxxxxxxxxx
	//TODO: FILTER DE QUE? O NOME NÃO É MUITO CLARO, TROQUEI O NOME E DEIXEI MAIS CLARO.xxxxxxxxxxx
	public Page<AuditfilterDTO> findAll(Pageable pageable, AuditfilterDTO auditfilterDTO) {
		Specification<AuditEntity> spec = AuditSpecification.getByFilter(auditfilterDTO);
		return auditRepository.findAll(spec, pageable)
				.map(AuditMapper::createAuditDTOFromEntity);
	}

	//TODO: ESSA PARECE UMA ABORDAGEM INTERESSANTE, MAS NÃO ATENDE AO RANGE DA DATAS (AGORA ATENDE KKKK).

}
