package com.keycloak.service.impl;

import com.keycloak.model.Organization;
import com.keycloak.repository.OrganisationRepository;
import com.keycloak.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganisationRepository organisationRepository;

    public OrganizationServiceImpl(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public Organization findById(Long organizationId) throws Exception {
        return organisationRepository.findById(organizationId).orElseThrow(()->
                new Exception("No organization found!"));
    }

    @Override
    public Organization create(Organization organization) {
        return organisationRepository.save(organization);
    }

    @Override
    public void delete(Long organizationId) {

        organisationRepository.deleteById(organizationId);
    }
}
