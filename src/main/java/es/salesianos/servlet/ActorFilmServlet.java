package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.repository.ActorRepository;
import es.salesianos.service.ActorService;

public class ActorFilmServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private ActorService service = new ActorService();
	
	private ActorAssembler actorAssembler = new ActorAssembler();

	private static final Logger log = LogManager.getLogger(ActorFilmServlet.class);

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Actor actor = actorAssembler.assembleActorfrom(req);

		service.insert(actor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String codString = req.getParameter("cod");
		
		log.info("Valor del parametro COD -> "+codString);
		
		if(null != codString) {
			service.delete(codString);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Actor> listAllActores = service.selectAllActor();
		req.setAttribute("listAllActores", listAllActores);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actorFilm.jsp");
		dispatcher.forward(req, resp);
	}
}
