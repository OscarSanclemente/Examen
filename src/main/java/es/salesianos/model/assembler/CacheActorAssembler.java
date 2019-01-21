package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.CacheActor;

public class CacheActorAssembler {

	public static CacheActor assembleCacheActorfrom(HttpServletRequest req) {
		CacheActor cacheActor = new CacheActor();
//		String name = req.getParameter("name");
//		int year = Integer.parseInt(req.getParameter("year"));
//		actor.setName(name);
//		actor.setYear(year);
		int codPelicula = Integer.parseInt(req.getParameter("cod"));
		int codActor = Integer.parseInt(req.getParameter("codActor"));
		int cache = Integer.parseInt(req.getParameter("cache"));
		String personaje = req.getParameter("personaje");
		
		cacheActor.setCache(cache);
		cacheActor.setCodFilm(codPelicula);
		cacheActor.setCodActor(codActor);
		cacheActor.setRole(personaje);

		return cacheActor;
	}
}