package it.ibs.tourismsquare.repository;

import it.ibs.tourismsquare.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
