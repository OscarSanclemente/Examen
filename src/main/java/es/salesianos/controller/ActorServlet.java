package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.service.ActorService;

@Controller
public class ActorServlet{


	@Autowired
	@Qualifier("actorService")
	private ActorService service;
	
	@Autowired
	private ActorAssembler actorAssembler;

	@PostMapping(path="/addActor")
	public String saveActor(Actor actor)  {
		service.insert(actor);
		return "actorSaved";
	}
	
	@GetMapping(path="addActor")
	public ModelAndView getAddOwnerPage() {
		ModelAndView model = new ModelAndView("addActor");
		model.addObject(new Actor());
		return model;
	}

	@GetMapping(path = "listAllActores")
	public String getListOwnerPage() {
		return "listAllActores";
	}

//	@GetMapping
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		String codString = req.getParameter("cod");
//		
//		if(null != codString) {
//			service.delete(codString);
//		}
//		doAction(req, resp);
//	}
//
//	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		String beginDateString = req.getParameter("year1");
//		if (beginDateString != null) {
//			int beginDate = Integer.parseInt(req.getParameter("year1"));
//			int endDate = Integer.parseInt(req.getParameter("year2"));
//			List<Actor> listAllActors = service.selectActorsBirthDate(beginDate, endDate);
//			req.setAttribute("listAllActores", listAllActors);
//		}else {
//			List<Actor> listAllActores = service.selectAllActor();
//			req.setAttribute("listAllActores", listAllActores);
//		}
//		redirect(req, resp);
//	}
//
//	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actor.jsp");
//		dispatcher.forward(req, resp);
//	}
}