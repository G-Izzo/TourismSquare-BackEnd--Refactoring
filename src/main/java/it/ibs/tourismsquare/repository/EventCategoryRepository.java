package it.ibs.tourismsquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ibs.tourismsquare.model.dao.EventCategory;

public interface EventCategoryRepository extends JpaRepository<EventCategory,Long> {
}
