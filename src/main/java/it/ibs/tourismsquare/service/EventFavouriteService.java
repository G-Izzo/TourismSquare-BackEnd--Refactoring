package it.ibs.tourismsquare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ibs.tourismsquare.repository.EventFavouriteRepository;

@Service
public class EventFavouriteService {
	
	@Autowired
	private EventFavouriteRepository eventFavouriteRepository;
}
