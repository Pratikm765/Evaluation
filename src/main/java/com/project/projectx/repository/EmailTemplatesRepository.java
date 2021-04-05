package com.project.pavani.repository;
/**
 * @author anusha.garg
 */

import com.project.pavani.models.EmailTemplates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link EmailTemplates} entity.
 */
public interface EmailTemplatesRepository extends JpaRepository<EmailTemplates, String> {
    EmailTemplates findOneByActionIgnoreCase(String action);
}
