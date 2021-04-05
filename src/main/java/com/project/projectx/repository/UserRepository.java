package com.project.pavani.repository;
/**
 * @author ayush.pandey
 */
import com.project.pavani.models.UserModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link UserModel} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<UserModel> findOneByEmailIgnoreCase(String email);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<UserModel> findOneWithAuthoritiesByEmailIgnoreCase(String email);
}
