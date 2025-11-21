package com.bezkoder.spring.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.webflux.model.Tutorial;
import com.bezkoder.spring.webflux.repository.TutorialRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class TutorialService {
	@Autowired
    private TutorialRepository tutorialRepository;

    public Mono<Tutorial> save(Tutorial tutorial) {
        return Mono.fromCallable(() -> tutorialRepository.save(tutorial))
                   .subscribeOn(Schedulers.boundedElastic());
    }
    
    public Flux<Tutorial> findAll() {
        return Mono.fromCallable(() -> tutorialRepository.findAll())
                   .subscribeOn(Schedulers.boundedElastic())
                   .flatMapMany(Flux::fromIterable);
    }
}
