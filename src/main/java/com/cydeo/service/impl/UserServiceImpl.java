package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
            return userRepository.findAll().stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {

        User user=userRepository.findByUserName(username);
        return userMapper.convertToDto(user);
    }

    @Override
    public void save(UserDTO dto) {

        userRepository.save(userMapper.convertToEntity(dto));
    }

    @Override
    public UserDTO update(UserDTO dto) {

        //find the current user
        User user=userRepository.findByUserName(dto.getUserName());

        //map updated user dto to entity object
        User convertedUser=userMapper.convertToEntity(dto);

        //set id to converted object
        convertedUser.setId(user.getId());

        //save updated user
        userRepository.save(convertedUser);

        return findByUserName(dto.getUserName());
    }

    @Override
    public void deleteByUserName(String username) {
    userRepository.deleteByUserName(username);

    }

    @Override
    public void delete(String username) {
       User user=userRepository.findByUserName(username);
       user.setDeleted(true);
       userRepository.save(user);
    }
}