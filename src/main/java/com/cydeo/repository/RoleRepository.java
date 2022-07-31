package com.cydeo.repository;

import com.cydeo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    //build all queries that will bring data from db
    //derive, @Query(JPA-Native)
    //ready repositories from Spring boot
    //there are 20 methods there in JPA repository



}
