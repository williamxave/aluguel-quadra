package com.projetoalguel.projetoAlguel.controller;

import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerDto;
import com.projetoalguel.projetoAlguel.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/v1/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerOwner(@RequestBody @Valid OwnerDto ownerDto, UriComponentsBuilder builder) {
        var owner = ownerService.toOwner(ownerDto);
        URI uri = builder.path("/{externalId}").buildAndExpand(owner.getExternalId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
