package br.es.gov.cb.cbmesaudit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "AUDITS")
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

    private String sourceApp;
    private Date creationDate;
    private String auditedUser;
    private String description;
//TODO: EVITE O USO DE LINHAS EM BRANCO DENTRO DE UMA CLASSE


}
