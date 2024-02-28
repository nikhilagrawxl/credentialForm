package com.nikhil.project.dao;

import com.nikhil.project.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails,Integer> {
}
