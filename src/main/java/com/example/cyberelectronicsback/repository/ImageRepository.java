package com.example.cyberelectronicsback.repository;

        import com.example.cyberelectronicsback.model.Image;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
