package com.Unislink.UnisLinkAPI.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Unislink.UnisLinkAPI.Entity.UserDetails;
import com.Unislink.UnisLinkAPI.Service.UserDetailsService;


@RestController
public class UserDetailsController {
	@Autowired
	private UserDetailsService us;
	
	@RequestMapping("/index")
	public String home(){
		return "index";
	}
	
	@PostMapping("/adduser")
	public String AddUser(@RequestBody UserDetails u) {
		us.CreateUser(u);
		return "User Add Successfully";
	}
	
	
	@PutMapping("/modifyuser/{id}")
	public String UpdateUser(@PathVariable Long id, @RequestBody UserDetails u) {
		us.UpdateUser(u);
		System.out.println("Updatygsidfnskdglbljkb");
		return "Update Successfully";
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String DeleteUser(@PathVariable Long id) {
		us.DeleteUser(id);
		return "Deleted Successfully";
	}
	
	@GetMapping("/get")
	public List<UserDetails> GetProduct(){
		return us.findUsersByAge();
	}
	
	@GetMapping("/api/users")
    public ResponseEntity<Page<UserDetails>> getAllUsers(Pageable pageable) {
        Page<UserDetails> users = us.findAllUsers(pageable);
        return ResponseEntity.ok(users);
    }
	
	 @PostMapping("/searchByHobbies")
	    public   List<UserDetails>  searchUsersByHobbies(@RequestBody  List<String>  selectedHobbies) {
		 System.out.println("dfghjhgfdfghjkjhgfgh->");
		 List<UserDetails> AgeData = new ArrayList<>();
	     List<UserDetails> users = us.findUsersByAge();
	       for (UserDetails userDetails : users) {
	        	if(userDetails.getHobbies().stream().anyMatch(selectedHobbies::contains)) {
	        		System.out.println("Max-->"+userDetails.getFirstname()+userDetails.getDate());
	        		AgeData.add(userDetails);
	        	}
			}
	        return AgeData;
	 }
	 
	 
	 @GetMapping("/searchByAge")
	    public List<UserDetails> searchUsersByAge(@RequestParam(name = "minAge", required = false) LocalDate minAge,
	                                   @RequestParam(name = "maxAge", required = false) LocalDate maxAge) {
		 	
		 List<UserDetails> AgeData = new ArrayList<>();
	        List<UserDetails> users = us.findUsersByAge();
	        for (UserDetails userDetails : users) {
	        	if((userDetails.getDate().isBefore(maxAge) &&userDetails.getDate().isAfter(minAge))) {
	        		System.out.println("Max-->"+userDetails.getFirstname()+userDetails.getDate());
	        		AgeData.add(userDetails);
	        	}
			}
	        return AgeData;
	    }
	 
	 @GetMapping("/SearchByName")
	    public List<UserDetails> searchUsersByAge(@RequestParam String searchfirst) {
		 	
		 List<UserDetails> AgeData = new ArrayList<>();
	        List<UserDetails> users = us.findUsersByAge();
	        for (UserDetails userDetails : users) {
	        	if((userDetails.getFirstname().toUpperCase().contains(searchfirst.toUpperCase())  || userDetails.getLastname().toUpperCase().contains(searchfirst.toUpperCase()))) {
	        		System.out.println("Max-->"+userDetails.getFirstname()+userDetails.getDate());
	        		AgeData.add(userDetails);
	        	}
			}
	        return AgeData;
	    }
}
