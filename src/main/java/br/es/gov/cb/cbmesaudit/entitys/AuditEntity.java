package br.es.gov.cb.cbmesaudit.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "AUDITS", indexes = {
        @Index(name = "idx_source_app", columnList = "source_app"),
        @Index(name = "idx_audited_user", columnList = "audited_user")
})
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_app", nullable = false)
    private String sourceApp;
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "audited_user", nullable = false)
    private String auditedUser;
    @Column(name = "description", nullable = false)
    private String description;
}
