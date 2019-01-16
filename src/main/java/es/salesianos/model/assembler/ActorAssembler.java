package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;

public class ActorAssembler {

	public static Actor assembleActorfrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String name = req.getParameter("name");
		int year = Integer.parseInt(req.getParameter("year"));
		actor.setName(name);
		actor.setYear(year);
		return actor;
	}
}