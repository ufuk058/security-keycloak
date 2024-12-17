package com.keycloak.repository;

import com.keycloak.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationRepository extends CrudRepository<Organization,Long> {
    Optional<Organization> findById(Long organizationId);
}
