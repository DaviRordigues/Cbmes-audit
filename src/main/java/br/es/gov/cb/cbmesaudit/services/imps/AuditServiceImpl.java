package br.es.gov.cb.cbmesaudit.services.imps;

import br.es.gov.cb.cbmesaudit.dtos.PagedAuditDTO;
import br.es.gov.cb.cbmesaudit.dtos.RequestAuditDTO;
import br.es.gov.cb.cbmesaudit.dtos.ResponseAuditDTO;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;
import br.es.gov.cb.cbmesaudit.mapper.AuditMapper;
import br.es.gov.cb.cbmesaudit.repositorys.AuditRepository;
import br.es.gov.cb.cbmesaudit.services.AuditService;
import br.es.gov.cb.cbmesaudit.specification.AuditSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {
	
	private final AuditRepository auditRepository;
	
	@Override
	public void create(RequestAuditDTO requestAuditDTO) {
		auditRepository.save(AuditMapper.createAuditEntityFromDTO(requestAuditDTO));
	}
	
	@Override
	public PagedAuditDTO findAll(Pageable pageable, RequestAuditDTO requestAuditDTO) {
		Specification<AuditEntity> spec = AuditSpecification.getByFilter(requestAuditDTO);
		Page<AuditEntity> page = auditRepository.findAll(spec, pageable);
		
		List<ResponseAuditDTO> audits = page.getContent()
				.stream()
				.map(AuditMapper::createAuditDTOFromEntity)
				.toList();
		
		return PagedAuditDTO.builder()
				.audits(audits)
				.currentPage(page.getNumber())
				.totalPages(page.getTotalPages())
				.totalItems(page.getTotalElements())
				.build();
	}
}
