package it.ibs.tourismsquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ibs.tourismsquare.model.dao.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
