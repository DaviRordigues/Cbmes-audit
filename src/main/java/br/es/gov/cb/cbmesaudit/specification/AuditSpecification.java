package br.es.gov.cb.cbmesaudit.specification;

import br.es.gov.cb.cbmesaudit.dtos.AuditRequestDTO;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuditSpecification {

    public static Specification<AuditEntity> getByFilter(AuditRequestDTO auditRequestDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (auditRequestDTO.getAuditedUsers() != null) {
                predicates.add(criteriaBuilder.equal(root.get("auditedUser"), auditRequestDTO.getAuditedUsers()));
            }

            if (auditRequestDTO.getSourceApss() != null) {
                predicates.add(criteriaBuilder.equal(root.get("sourceApp"), auditRequestDTO.getSourceApss()));
            }

            if (auditRequestDTO.getStartDate() != null && auditRequestDTO.getEndDate() != null) {
                predicates.add(criteriaBuilder.between(
                        root.get("creationDate"),
                        auditRequestDTO.getStartDate(),
                        auditRequestDTO.getEndDate()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
