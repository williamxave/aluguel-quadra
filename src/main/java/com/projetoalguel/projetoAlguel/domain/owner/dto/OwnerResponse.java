package com.projetoalguel.projetoAlguel.domain.owner.dto;

import com.projetoalguel.projetoAlguel.domain.owner.Owner;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OwnerResponse {

    private String name;
    private String email;

    public OwnerResponse(Owner owner){
        this.name = owner.getName();
        this.email = owner.getEmail();
    }
}
