package com.keycloak.controller;

import com.keycloak.model.Organization;
import com.keycloak.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") Long organizationId) throws Exception {

        return ResponseEntity.ok(organizationService.findById(organizationId));
    }

    @PostMapping("/create")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationService.create(organization));
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable("organizationId") Long organizationId){
        organizationService.delete(organizationId);
        return ResponseEntity.noContent().build();
    }
}
