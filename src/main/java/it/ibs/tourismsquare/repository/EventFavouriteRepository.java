package it.ibs.tourismsquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ibs.tourismsquare.model.dao.EventFavourite;

public interface EventFavouriteRepository extends JpaRepository<EventFavourite, Long> {
}
