package es.salesianos.model.assembler;

import org.springframework.stereotype.Component;

import es.salesianos.model.Director;

@Component
public class DirectorAssembler {

	public static Director assembleDirectorfrom(Integer codDirector, String name) {
		
		Director director = new Director();
		
		if(null != codDirector) {
			director.setCod(codDirector);
		}
		director.setName(name);
		
		return director;
	}
}