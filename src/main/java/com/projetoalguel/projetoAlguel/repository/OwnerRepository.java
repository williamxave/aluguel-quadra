package com.projetoalguel.projetoAlguel.repository;

import com.projetoalguel.projetoAlguel.domain.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
