package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    // if you want to use any method from model mapper class what we need to do - injection

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //convert to entity

    public Role convertToEntity(RoleDTO dto){
        return modelMapper.map(dto, Role.class);
    }

    //convert to dto
    public RoleDTO convertToDto(Role entity){

        return modelMapper.map(entity, RoleDTO.class);
    }


}
