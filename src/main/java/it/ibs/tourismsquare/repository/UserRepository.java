package it.ibs.tourismsquare.repository;

import it.ibs.tourismsquare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
