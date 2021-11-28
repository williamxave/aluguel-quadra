package com.projetoalguel.projetoAlguel.service;

import com.projetoalguel.projetoAlguel.domain.owner.Owner;
import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerDto;
import com.projetoalguel.projetoAlguel.mapper.MapperInterface;
import com.projetoalguel.projetoAlguel.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Owner toOwner(OwnerDto ownerDto){
       var owner = mapperInterface.ownerDtoFromOwner(ownerDto);

        System.out.println(owner.getId());
       ownerRepository.save(owner);
       return owner;
    }
}
