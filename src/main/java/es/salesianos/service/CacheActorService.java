package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.model.CacheActor;
import es.salesianos.repository.CacheActorRepository;

public class CacheActorService {


	private CacheActorRepository repository = new CacheActorRepository();
	
	public void insert(CacheActor cacheActor) {
		repository.insertCacheActor(cacheActor);
	}
	
	public List<Actor> selectActor(String role){
		repository.selectActor(role);
	}

}