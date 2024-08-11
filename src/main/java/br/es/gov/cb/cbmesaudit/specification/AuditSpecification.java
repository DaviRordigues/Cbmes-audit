package br.es.gov.cb.cbmesaudit.specification;

import br.es.gov.cb.cbmesaudit.dtos.RequestAuditDTO;
import br.es.gov.cb.cbmesaudit.entities.AuditEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditSpecification {

    public static Specification<AuditEntity> getByFilter(RequestAuditDTO requestAuditDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (requestAuditDTO.getAuditedUser() != null) {
                predicates.add(criteriaBuilder.equal(root.get("auditedUser"), requestAuditDTO.getAuditedUser()));
            }

            if (requestAuditDTO.getSourceApp() != null) {
                predicates.add(criteriaBuilder.equal(root.get("sourceApp"), requestAuditDTO.getSourceApp()));
            }

            if (requestAuditDTO.getCreationDate() != null) {
                LocalDateTime startOfDay = requestAuditDTO.getCreationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
                LocalDateTime endOfDay = startOfDay.plusDays(1).minusSeconds(1);
                predicates.add(criteriaBuilder.between(root.get("creationDate"),
                        Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant()),
                        Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant())));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
