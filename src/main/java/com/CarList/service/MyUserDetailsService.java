//package com.CarList.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.CarList.entity.User;
//import com.CarList.repository.UserRepository;
//import com.CarList.security.UserPrincipal;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired 
//	private UserRepository userRepository;
//	
//	// Register New User
//	public User createUser(User user) {
//		user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword())); // raw password(ganesh123) save nhi hoga encoded formate mein save hoga ex-> dgfusg*&%^*&Dhgew87ew
//		return userRepository.save(user);
//	}
//
//	 // Load User For Authentication
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findByUsername(username);
//		if(user.isEmpty())throw new UsernameNotFoundException("User Not Found!!!");
//		return new UserPrincipal(user.get()); // UserPrincipal class banana parega 
//		
//		/* Ye method database se user load karta hai aur usko UserDetails (UserPrincipal) me convert karke Spring Security ko return karta hai.*/
//	}
//	
//	
//}
