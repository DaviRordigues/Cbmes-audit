package br.es.gov.cb.cbmesaudit.specification;

import br.es.gov.cb.cbmesaudit.dtos.AuditfilterDTO;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;

public class AuditSpecification {

    public static Specification<AuditEntity> getByFilter(AuditfilterDTO AuditfilterDTO ) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (AuditfilterDTO .getSourceApp() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(root.get("sourceApp"), AuditfilterDTO .getSourceApp()));
            }
            if (AuditfilterDTO .getAuditedUser() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(root.get("auditedUser"), AuditfilterDTO .getAuditedUser()));
            }
            if (AuditfilterDTO.getStartDate() != null && AuditfilterDTO.getEndDate() != null) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.between(root.get("creationDate"), AuditfilterDTO.getStartDate(), AuditfilterDTO.getEndDate())
                );
            }

            return predicate;
        };
    }
}
