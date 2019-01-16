package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.service.FilmService;

public class FilmServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private FilmService service = new FilmService();
	
	private FilmAssembler filmAssembler = new FilmAssembler();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Film film = filmAssembler.assembleActorfrom(req);
		
		service.insertFilm(film);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Film film = filmAssembler.assembleActorfrom(req);

		if(null != film.getCod()) {
			service.deleteFilm(film);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Film> selectAllFilms = service.selectAllFilms();
		req.setAttribute("listAllFilms", selectAllFilms);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/film.jsp");
		dispatcher.forward(req, resp);
	}
}