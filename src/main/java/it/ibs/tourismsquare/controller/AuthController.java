package it.ibs.tourismsquare.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.ibs.tourismsquare.model.dao.User;
import it.ibs.tourismsquare.model.dto.LoginRequest;
import it.ibs.tourismsquare.model.dto.MessageResponse;
import it.ibs.tourismsquare.model.dto.SignupRequest;
import it.ibs.tourismsquare.repository.UserMetaRepository;
import it.ibs.tourismsquare.repository.UserRepository;

@RestController
@RequestMapping("api/auth")
public class AuthController {  

  @Autowired
  private UserRepository userRepository;

  //@Autowired private RoleRepository roleRepository;
  
  @Autowired
  private UserMetaRepository userMetaRepository;

  /*@Autowired
  private JwtUtils jwtUtils;*/

  @PostMapping("/signup")
  public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.findByEmail(signUpRequest.getEmail()))
    	return new ResponseEntity<MessageResponse>(new MessageResponse("Email già in uso"), HttpStatus.BAD_REQUEST);
    
    User user = new User(
    		signUpRequest.getName(),
    		signUpRequest.getSurname(),
    		signUpRequest.getCity(),
    		signUpRequest.getEmail(),
    		signUpRequest.getPassword(),
    		new Date());
    
    userRepository.save(user);
    
    return ResponseEntity.ok(new MessageResponse("Registrazione avvenuta con successo!"));	
  }
  
  @PostMapping("/signin")
  public ResponseEntity<MessageResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest){
	if(!userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()))
		return new ResponseEntity<MessageResponse>(new MessageResponse("Email o password errate!"), HttpStatus.BAD_REQUEST);
	
	
	return new ResponseEntity<MessageResponse>(new MessageResponse("Login avvenuto con successo!"), HttpStatus.OK);		
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {/*
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));*/
	  return null;
  }
}

