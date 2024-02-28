package com.nikhil.project.dao;

import com.nikhil.project.entity.User;
import com.nikhil.project.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {

}
