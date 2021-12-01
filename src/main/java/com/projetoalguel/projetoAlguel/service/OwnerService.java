package com.projetoalguel.projetoAlguel.service;

import com.projetoalguel.projetoAlguel.domain.owner.Owner;
import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerDto;
import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerResponse;
import com.projetoalguel.projetoAlguel.mapper.MapperInterface;
import com.projetoalguel.projetoAlguel.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    private MapperInterface mapperInterface;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository,
                        MapperInterface mapperInterface) {
        this.ownerRepository = ownerRepository;
        this.mapperInterface = mapperInterface;
    }

    public Owner toOwner(OwnerDto ownerDto) {
        var owner = mapperInterface.ownerDtoFromOwner(ownerDto);
        ownerRepository.save(owner);
        return owner;
    }

    public Optional<Owner> deleteOnwer(String externalId) {
        var possibleOwner = searchOwner(externalId);
        if (possibleOwner.isEmpty()) {
            return Optional.empty();
        }
        possibleOwner.ifPresent(owner -> ownerRepository.delete(owner));
        return possibleOwner;
    }

    public Optional<Owner> searchOwner(String externalId) {
        var possibleOwner = ownerRepository.findOwnerByExternalId(UUID.fromString(externalId))
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));
        return Optional.ofNullable(possibleOwner);
    }

    public OwnerResponse ownerFromOwnerResponse(String externalId){
        return searchOwner(externalId).map(owner -> new OwnerResponse(owner)).get();
    }

    public void updateOwner (String externalId, OwnerDto ownerDto){
        var owner = searchOwner(externalId);
        owner.get().setEmail(ownerDto.getEmail());
        owner.get().setName(ownerDto.getName());
        owner.get().setPassword(ownerDto.getPassword());
        owner.get().upDate();
        ownerRepository.save(owner.get());
    }
}
