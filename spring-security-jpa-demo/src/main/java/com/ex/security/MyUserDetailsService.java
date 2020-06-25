package com.ex.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ex.models.MyUserDetails;
import com.ex.models.UserEntitiy;
import com.ex.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserEntitiy> entitiy=userRepo.findByUsername(username);
		
		entitiy.orElseThrow(()->new UsernameNotFoundException("Not found:"+username));
		
		return entitiy.map(MyUserDetails::new).get();
	}

}
