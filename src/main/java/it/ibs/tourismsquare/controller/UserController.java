package it.ibs.tourismsquare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ibs.tourismsquare.model.dao.User;
import it.ibs.tourismsquare.model.dto.MessageResponse;
import it.ibs.tourismsquare.service.UserService;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll(){
		try {
			List<User> res = userService.getAll();
			if(res.isEmpty())
				return new ResponseEntity<List<User>>(res, HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<User>>(res, HttpStatus.OK);		
		}
		catch (Exception e) {
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") Long id){	
		try {
			User res = userService.getById(id);
			return new ResponseEntity<User>(res, HttpStatus.OK);		
		}
		catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/add")
	public ResponseEntity<MessageResponse> add(@RequestBody User u){		
		try {
			userService.add(u);
			return new ResponseEntity<MessageResponse>(new MessageResponse("Utente Registrato"), HttpStatus.CREATED);	
		}
		catch (Exception e) {
			return new ResponseEntity<MessageResponse>(new MessageResponse("Si è verificato un errore"), HttpStatus.BAD_REQUEST);	
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MessageResponse> updateById(@PathVariable(name = "id") Long id, @RequestBody User u){		
		try {
			userService.updateById(id,u);
			return new ResponseEntity<MessageResponse>(new MessageResponse("Utente Aggiornato"), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<MessageResponse>(new MessageResponse("Si è verificato un errore"), HttpStatus.BAD_REQUEST);	
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MessageResponse> deleteById(@PathVariable(name = "id") Long id){	
		try {
			userService.deleteById(id);
			return new ResponseEntity<MessageResponse>(new MessageResponse("Utente Eliminato"), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<MessageResponse>(new MessageResponse("Si è verificato un errore"), HttpStatus.BAD_REQUEST);
		}		
	}
}
