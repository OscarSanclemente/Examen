package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.CacheActor;
import es.salesianos.model.Director;
import es.salesianos.model.assembler.CacheActorAssembler;
import es.salesianos.service.CacheActorService;

public class CacheActorServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private CacheActorService service = new CacheActorService();
	
	private CacheActorAssembler cacheActorAssembler = new CacheActorAssembler();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CacheActor cacheActor = cacheActorAssembler.assembleCacheActorfrom(req);
		
		service.insert(cacheActor);
		
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role = req.getParameter("role");
//		if (role != null) {
//			List<Actor> actor = service.selectActor(role);
//			req.setAttribute("actor", actor);
//		}
		
		FALTA BUSCAR POR PERSONAJE INTERPRETADO(LOS DOS ULTIMOS PUNTOS QUE PEDIA EN EL EXAMEN)
		
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