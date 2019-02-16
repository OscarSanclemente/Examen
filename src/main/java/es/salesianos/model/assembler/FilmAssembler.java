package es.salesianos.model.assembler;

import org.springframework.stereotype.Component;

import es.salesianos.model.Film;

@Component
public class FilmAssembler {

	public static Film assembleActorfrom(String title, Integer codDirector) {

		Film film = new Film();
		
		film.setCodDirector(codDirector);
		film.setTitle(title);
		
		return film;
	}
}