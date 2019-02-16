package es.salesianos.model.assembler;

import org.springframework.stereotype.Component;

import es.salesianos.model.FilmActor;

@Component
public class FilmActorAssembler {

	public static FilmActor assembleFilmActorFrom(Integer codFilm, Integer codActor, Integer cache, String role) {
		FilmActor filmActor = new FilmActor();
		
		filmActor.setCodFilm(codFilm);
		filmActor.setCodActor(codActor);
		filmActor.setCache(cache);
		filmActor.setRole(role);
		return filmActor;
	}
}