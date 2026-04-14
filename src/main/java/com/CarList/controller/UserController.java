//package com.CarList.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.CarList.dto.UserDTO;
//import com.CarList.entity.User;
//import com.CarList.security.JwtUtil;
//import com.CarList.service.MyUserDetailsService;
//
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//	
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private MyUserDetailsService userDetailsService;
//	
//	@PostMapping("/register")
//	public User register(@RequestBody User user) {
//		return userDetailsService.createUser(user);
//	}
//	
//	// Login API (Token Generate Karega)
//	 @PostMapping("/login")
//	    public String login(@RequestBody UserDTO userDTO){
//	        // Step 1: User Authenticate Karo
//	        Authentication authentication = authenticationManager.authenticate(  // agar authentication successful hua toh user ko authenticated mark kar do
//	                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));  // username + password ka authentication object bana rahe hain
//	        // Step 2: Security Context Mein Set Karo
//	        SecurityContextHolder.getContext().setAuthentication(authentication);  // agar authentication successful hua toh user ko authenticated mark kar do
//	        // Step 3: User Ke Roles Extract Karo
//	       List<String> roles =  authentication.getAuthorities()
//	               .stream().map(GrantedAuthority::getAuthority).toList();
//	        // Step 4: Database Se UserDetails Load Karo
//	        UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
//	        // Step 5: JWT Token Generate Aur Return Karo
//	        return jwtUtil.generateToken(userDetails.getUsername(), roles );
//	}
//	
//	
//}
//
//
//
//
//
//
//
