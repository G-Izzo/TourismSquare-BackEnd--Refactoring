package it.ibs.tourismsquare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ibs.tourismsquare.model.dao.User;
import it.ibs.tourismsquare.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(Long id) {
		return userRepository.getReferenceById(id);
	}

	public void add(User u) {
		userRepository.save(u);
	}

	public void updateById(Long id, User u) {
		User user=userRepository.getReferenceById(id);
		u.setId(user.getId());		
		userRepository.save(u);	
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);		
	}
}
