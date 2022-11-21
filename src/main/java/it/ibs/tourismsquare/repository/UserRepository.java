package it.ibs.tourismsquare.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ibs.tourismsquare.model.dao.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(@NotNull String email, @NotNull String password);

	User findByEmail(@NotNull String email);
}
