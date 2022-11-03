package it.ibs.tourismsquare.repository;

import it.ibs.tourismsquare.model.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCategoryRepository extends JpaRepository<EventCategory,Long> {
}
