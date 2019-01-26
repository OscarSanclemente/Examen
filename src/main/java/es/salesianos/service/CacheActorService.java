package es.salesianos.service;

import es.salesianos.model.ActorFilmDto;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class CacheActorService {


	private FilmActorRepository repository = new FilmActorRepository();
	
	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}
	public ActorFilmDto filterAllFilmActor(String role) {
		return repository.filterAllFilmActor(role);
	}
}