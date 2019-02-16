package es.salesianos.model.assembler;

import org.springframework.stereotype.Component;

import es.salesianos.model.FilmActor;

@Component
public class CacheActorAssembler {

	public static FilmActor assembleFilmActorfrom(Integer codPelicula, Integer codActor, Integer cache, String personaje) {
		FilmActor cacheActor = new FilmActor();
		
		cacheActor.setCache(cache);
		cacheActor.setCodFilm(codPelicula);
		cacheActor.setCodActor(codActor);
		cacheActor.setRole(personaje);

		return cacheActor;
	}
}