package it.ibs.tourismsquare.repository;

import it.ibs.tourismsquare.model.UserInterests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestsRepository extends JpaRepository<UserInterests, Long> {
}
