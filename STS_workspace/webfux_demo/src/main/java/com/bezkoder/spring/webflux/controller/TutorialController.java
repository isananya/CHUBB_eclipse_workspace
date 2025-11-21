package com.bezkoder.spring.webflux.controller;

import com.bezkoder.spring.webflux.model.Tutorial;
import com.bezkoder.spring.webflux.service.TutorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
	@Autowired
	private TutorialService tutorialService;

	@GetMapping
	public Flux<Tutorial> getAllTutorials() {
		return tutorialService.findAll();
	}

	@PostMapping
	public Mono<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
		return tutorialService.save(tutorial);
	}
}