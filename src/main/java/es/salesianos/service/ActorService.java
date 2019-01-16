package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

public class ActorService {


	private ActorRepository repository = new ActorRepository();

	public List<Actor> selectAllActor() {
			return repository.selectAllActor();
	}
	
	public void insert(Actor actor) {
		repository.insertActor(actor);

	}
	
	public void delete(Actor actor) {
		repository.deleteActor(actor);

	}

}