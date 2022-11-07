package it.ibs.tourismsquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ibs.tourismsquare.config.security.ERole;
import it.ibs.tourismsquare.model.dao.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(ERole roleUser);

}
