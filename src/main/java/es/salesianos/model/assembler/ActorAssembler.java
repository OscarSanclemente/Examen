package es.salesianos.model.assembler;

import org.springframework.stereotype.Component;

import es.salesianos.model.Actor;

@Component
public class ActorAssembler {

	public static Actor assembleActorfrom(String name, Integer year) {
		Actor actor = new Actor();
		actor.setName(name);
		actor.setYear(year);
		return actor;
	}
}