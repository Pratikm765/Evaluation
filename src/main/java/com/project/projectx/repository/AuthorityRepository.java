package com.project.pavani.repository;
/**
 * @author ayush.pandey
 */
import com.project.pavani.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
