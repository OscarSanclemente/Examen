package es.salesianos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.FilmActor;
import es.salesianos.model.assembler.CacheActorAssembler;
import es.salesianos.service.CacheActorService;

public class CacheActorServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private CacheActorService service = new CacheActorService();
	
	private CacheActorAssembler cacheActorAssembler = new CacheActorAssembler();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FilmActor cacheActor = cacheActorAssembler.assembleFilmActorfrom(req);
		
		service.insert(cacheActor);
		
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cacheActor.jsp");
		dispatcher.forward(req, resp);
	}
}