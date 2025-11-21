package com.bezkoder.spring.webflux.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.webflux.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
}
