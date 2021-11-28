package com.projetoalguel.projetoAlguel.mapper;

import com.projetoalguel.projetoAlguel.domain.owner.Owner;
import com.projetoalguel.projetoAlguel.domain.owner.dto.OwnerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperInterface {

    Owner ownerDtoFromOwner(OwnerDto ownerDto);
}
