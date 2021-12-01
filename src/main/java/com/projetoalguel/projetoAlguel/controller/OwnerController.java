package com.projetoalguel.projetoAlguel.controller;

import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerDto;
import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerResponse;
import com.projetoalguel.projetoAlguel.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("api/v1/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/{externalId}")
    public  ResponseEntity<OwnerResponse> searchOwner(@PathVariable String externalId){
        var ownerResponse = ownerService.ownerFromOwnerResponse(externalId);
        return ResponseEntity.ok().body(ownerResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerOwner(@RequestBody @Valid OwnerDto ownerDto, UriComponentsBuilder builder) {
        var owner = ownerService.toOwner(ownerDto);
        log.info("Registered owner succesfull {}", owner.getEmail());

        URI uri = builder.path("/{externalId}").buildAndExpand(owner.getExternalId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("delete/{externalId}")
    public ResponseEntity<?> deleteOwner(@PathVariable String externalId){
       var owner= ownerService.deleteOnwer(externalId);
       if (owner.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       log.info("Deleted owner succesfull {} ", owner.get().getEmail());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{externalId}")
    public ResponseEntity<?> updateOwner( @PathVariable String externalId,
                                          @Valid @RequestBody OwnerDto ownerDto){
        ownerService.updateOwner(externalId, ownerDto);
        log.info("Update Owner {} ",ownerDto.getEmail());
        return ResponseEntity.ok().build();
    }
}
