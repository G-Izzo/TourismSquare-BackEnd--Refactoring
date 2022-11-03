package it.ibs.tourismsquare.repository;

import it.ibs.tourismsquare.model.EventFavourite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventFavouriteRepository extends JpaRepository<EventFavourite, Long> {
}
