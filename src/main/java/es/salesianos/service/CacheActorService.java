package es.salesianos.service;

import es.salesianos.model.CacheActor;
import es.salesianos.repository.CacheActorRepository;

public class CacheActorService {


	private CacheActorRepository repository = new CacheActorRepository();
	
	public void insert(CacheActor cacheActor) {
		repository.insertCacheActor(cacheActor);
	}

}