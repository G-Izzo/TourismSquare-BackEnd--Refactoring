package it.ibs.tourismsquare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ibs.tourismsquare.repository.EventCategoryRepository;

@Service
public class EventCategoryService {

	@Autowired
	private EventCategoryRepository eventCategoryRepository;
}
