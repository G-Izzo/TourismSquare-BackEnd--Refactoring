package it.ibs.tourismsquare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ibs.tourismsquare.repository.UserMetaRepository;

@Service
public class UserMetaService {
	
	@Autowired
	private UserMetaRepository userMetaRepository;
}
