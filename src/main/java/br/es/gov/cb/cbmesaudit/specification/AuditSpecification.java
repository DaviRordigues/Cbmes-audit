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

            if (auditRequestDTO.getAuditedUser() != null) {
                predicates.add(criteriaBuilder.equal(root.get("auditedUser"), auditRequestDTO.getAuditedUser()));
            }

            if (auditRequestDTO.getSourceApp() != null) {
                predicates.add(criteriaBuilder.equal(root.get("sourceApp"), auditRequestDTO.getSourceApp()));
            }

            if (auditRequestDTO.getStartTime() != null && auditRequestDTO.getEndTime() != null) {
                predicates.add(criteriaBuilder.between(
                        root.get("creationDate"),
                        auditRequestDTO.getStartTime(),
                        auditRequestDTO.getEndTime()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
