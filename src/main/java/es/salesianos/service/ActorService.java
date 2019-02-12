package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

@Service("actorService")
public class ActorService {
	
	@Autowired
	private ActorRepository repository;

	public List<Actor> selectAllActor() {
			return repository.selectAllActor();
	}
	
	public void insert(Actor actor) {
		repository.insertActor(actor);
	}
	
	public void delete(String codString) {
		
		Actor actor = new Actor();
		
		int cod = Integer.parseInt(codString);
		actor.setCod(cod);
		
		repository.deleteActor(actor);
	}
	
	public List<Actor> selectActorsBirthDate(int year1, int year2){
		return repository.selectActors(year1, year2);
	}

}