package com.Unislink.UnisLinkAPI.Service;

import java.time.LocalDate;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Unislink.UnisLinkAPI.Entity.UserDetails;
import com.Unislink.UnisLinkAPI.Repository.UserDetailsRepository;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsRepository ur;
	
	//Add User
	public void CreateUser(UserDetails u) {
		ur.save(u);
	}
	
	//Update User
	public UserDetails UpdateUser(UserDetails user) {
		UserDetails existingUser = ur.findById(user.getId()).orElse(null);
		System.out.println(user.getId() +   user.getFirstname());
        if (existingUser != null) {
            // Update user details
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setEmail(user.getEmail());
            existingUser.setDate(user.getDate());
            existingUser.setGender(user.getGender());
            existingUser.setHobbies(user.getHobbies());
            existingUser.setInterest(user.getInterest());
            // Save the updated user
            return ur.save(existingUser);
        } else {
            return null; // User not found
        }
	}
	
	//DeleteUser
	public void DeleteUser(Long id) {
		ur.deleteById(id);
	}
	
    public Page<UserDetails> findAllUsers(Pageable pageable) {
        return ur.findAll(pageable);
    }
    //Get  User
    public List<UserDetails> findUsersByAge() {
        return ur.findAll();
    }
    
    
}