package es.salesianos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.ActorFilmDto;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

@Service("cacheActorService")
public class CacheActorService {

	@Autowired
	private FilmActorRepository repository;
	
	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}
	public ActorFilmDto filterAllFilmActor(String role) {
		return repository.filterAllFilmActor(role);
	}
}