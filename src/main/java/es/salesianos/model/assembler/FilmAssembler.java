package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.Film;

@Component
public class FilmAssembler {

	public static Film assembleActorfrom(HttpServletRequest req) {

		Film film = new Film();
		
		String title = req.getParameter("title");
		String codDirectorString = req.getParameter("codDirector");
		int codDirector = Integer.parseInt(codDirectorString);
		film.setCodDirector(codDirector);
		film.setTitle(title);
		
		return film;
	}
}