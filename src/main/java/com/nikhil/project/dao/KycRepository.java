package com.nikhil.project.dao;

import com.nikhil.project.entity.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycRepository extends JpaRepository<Kyc,Integer> {

}
