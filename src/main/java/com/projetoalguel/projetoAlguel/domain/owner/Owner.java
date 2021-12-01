package com.projetoalguel.projetoAlguel.domain.owner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @Column(name = "external_Id")
    private UUID externalId;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @Column(name = "create_At")
    private LocalDateTime createAt;

    private LocalDateTime upDate;

    @PrePersist
    private void prePersist(){
        externalId = UUID.randomUUID();
        createAt = LocalDateTime.now();
    }

    public void upDate(){
        upDate = LocalDateTime.now();
    }
}
