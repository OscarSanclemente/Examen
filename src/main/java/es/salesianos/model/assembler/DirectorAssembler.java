package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.Director;

@Component
public class DirectorAssembler {

	public static Director assembleDirectorfrom(HttpServletRequest req) {
		
		Director director = new Director();
		
		String codDirector = req.getParameter("cod");
		if(null != codDirector) {
			director.setCod(Integer.parseInt(codDirector));
		}
		String name = req.getParameter("name");
		director.setName(name);
		
		return director;
	}
}