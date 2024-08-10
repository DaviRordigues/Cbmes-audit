package br.es.gov.cb.cbmesaudit.repository;

import br.es.gov.cb.cbmesaudit.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Long> {
}
