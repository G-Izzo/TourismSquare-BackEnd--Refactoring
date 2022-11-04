package it.ibs.tourismsquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ibs.tourismsquare.model.dao.UserMeta;

public interface UserMetaRepository extends JpaRepository<UserMeta, Long> {
}
