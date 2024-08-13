package br.es.gov.cb.auditapp.repositorys;

import br.es.gov.cb.auditapp.entities.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Long>, JpaSpecificationExecutor<AuditEntity> {
}
