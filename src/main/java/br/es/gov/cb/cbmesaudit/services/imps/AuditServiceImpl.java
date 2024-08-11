package br.es.gov.cb.cbmesaudit.services.imps;

import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditResponseDTO;
import br.es.gov.cb.cbmesaudit.dtos.AuditPagedDTO;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {

	private final AuditRepository auditRepository;

	@Override
	public void create(AuditRequestDTO auditRequestDTO) {
		auditRepository.save(AuditMapper.createAuditEntityFromDTO(auditRequestDTO));
	}

	@Override
	public AuditPagedDTO findAll(Pageable pageable, AuditRequestDTO auditRequestDTO) {
		Specification<AuditEntity> spec = AuditSpecification.getByFilter(auditRequestDTO);
		Page<AuditEntity> page = auditRepository.findAll(spec, pageable);

		List<AuditResponseDTO> audits = page.getContent()
				.stream()
				.map(AuditMapper::createAuditDTOFromEntity)
				.collect(Collectors.toList());

		return AuditPagedDTO.builder()
				.audits(audits)
				.currentPage(page.getNumber())
				.totalPages(page.getTotalPages())
				.totalItems(page.getTotalElements())
				.build();
	}
}
