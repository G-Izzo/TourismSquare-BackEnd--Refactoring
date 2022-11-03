package it.ibs.tourismsquare.repository;

import it.ibs.tourismsquare.model.UserMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMetaRepository extends JpaRepository<UserMeta, Long> {
}
