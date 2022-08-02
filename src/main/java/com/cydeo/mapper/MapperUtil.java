package com.cydeo.mapper;


import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public <T> T convert(Object objectToBeConverted, T convertedObject){

        return modelMapper.map(objectToBeConverted, (Type) convertedObject.getClass());
    }

//    //convert to entity
//
//    public <T> T convertToEntity(Object objectToBeConverted, T convertedObject){
//
//        return modelMapper.map(objectToBeConverted, (Type) convertedObject.getClass());
//    }
//
//    //convert to dto
//    public <T> T convertToDTO(Object objectToBeConverted, T convertedObject){
//
//        return modelMapper.map(objectToBeConverted, (Type) convertedObject.getClass());
//    }
}
