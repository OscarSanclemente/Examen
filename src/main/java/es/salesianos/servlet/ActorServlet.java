package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.service.ActorService;

public class ActorServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private ActorService service = new ActorService();
	private ActorAssembler actorAssembler = new ActorAssembler();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Actor actor = actorAssembler.assembleActorfrom(req);
		service.insert(actor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String codString = req.getParameter("cod");
		
		if(null != codString) {
			service.delete(codString);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String beginDateString = req.getParameter("year1");
		if (beginDateString != null) {
			int beginDate = Integer.parseInt(req.getParameter("year1"));
			int endDate = Integer.parseInt(req.getParameter("year2"));
			List<Actor> listAllActors = service.selectActorsBirthDate(beginDate, endDate);
			req.setAttribute("listAllActores", listAllActors);
		}else {
			List<Actor> listAllActores = service.selectAllActor();
			req.setAttribute("listAllActores", listAllActores);
		}
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actor.jsp");
		dispatcher.forward(req, resp);
	}
}