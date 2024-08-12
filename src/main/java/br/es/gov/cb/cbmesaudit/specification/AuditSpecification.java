package br.es.gov.cb.cbmesaudit.specification;

import br.es.gov.cb.cbmesaudit.dtos.AuditFilterDTO;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuditSpecification {
	
	private AuditSpecification() {
		super();
	}
	
	public static Specification<AuditEntity> getByFilter(AuditFilterDTO auditFilterDTO) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if (auditFilterDTO.getAuditedUsers() != null && !auditFilterDTO.getAuditedUsers().isEmpty()) {
				predicates.add(criteriaBuilder.or(auditFilterDTO.getAuditedUsers().stream()
						.map(user -> criteriaBuilder.like(root.get("auditedUser"), "%" + user + "%"))
						.toArray(Predicate[]::new)));
			}
			
			if (auditFilterDTO.getSourceApps() != null && !auditFilterDTO.getSourceApps().isEmpty()) {
				predicates.add(criteriaBuilder.or(auditFilterDTO.getSourceApps().stream()
						.map(app -> criteriaBuilder.like(root.get("sourceApp"), "%" + app + "%"))
						.toArray(Predicate[]::new)));
			}
			
			if (auditFilterDTO.getStartDate() != null && auditFilterDTO.getEndDate() != null) {
				predicates.add(criteriaBuilder.between(root.get("creationDate"),
						auditFilterDTO.getStartDate(), auditFilterDTO.getEndDate()));
			}
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
