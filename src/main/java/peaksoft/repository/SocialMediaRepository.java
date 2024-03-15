package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.SocialMedia;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {
}