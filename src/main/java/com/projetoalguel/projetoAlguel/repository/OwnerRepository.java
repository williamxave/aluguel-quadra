package com.projetoalguel.projetoAlguel.repository;

import com.projetoalguel.projetoAlguel.domain.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findOwnerByExternalId(UUID externalId);
}
