package com.Unislink.UnisLinkAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Unislink.UnisLinkAPI.Entity.UserDetails;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.*;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
	Page<UserDetails> findAll(Pageable pageable);
   
    

}
