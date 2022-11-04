package it.ibs.tourismsquare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ibs.tourismsquare.repository.ReminderRepository;

@Service
public class ReminderService {

	@Autowired
	private ReminderRepository reminderRepository;
}
