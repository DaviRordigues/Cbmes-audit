package br.es.gov.cb.auditapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
//TODO: EXISTE UMA ABORDAGEM MELHOR PARA INDEXES, QUE É USAR O @Index DIRETAMENTE NO ATRIBUTO
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

    @Column(name = "source_app", nullable = false, length = 100)
    //TODO: POR PADRAO, O TAMANHO DA COLUNA É 255. PARA UM NOME DE APLICAÇÃO, ESSE TAMANHO PODE SER GRANDE DEMAISXXXXXXXXXXX
    private String sourceApp;

    @Column(name = "creation_date", nullable = false, updatable = false) //TODO: CREATION DATE PRECISA SER AUTOGERADO E NAO PASSADO VIA DTOXXXXXX
    @Temporal(TemporalType.TIMESTAMP)
    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }
    private Date creationDate;

    @Column(name = "audited_user", nullable = false, length = 100)
    //TODO: POR PADRAO, O TAMANHO DA COLUNA É 255. PARA UM NOME DE USUARIO, ESSE TAMANHO PODE SER GRANDE DEMAISXXXXXXXXXX
    private String auditedUser;
    @Column(name = "description", nullable = false)
    private String description;
}
