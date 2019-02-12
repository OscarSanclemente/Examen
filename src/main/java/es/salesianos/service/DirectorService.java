package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Director;
import es.salesianos.repository.DirectorRepository;

@Service("directorService")
public class DirectorService {

	@Autowired
	private DirectorRepository repository;

	public List<Director> selectAllDirector() {
		return repository.selectAllDirector();
	}
	
	public void insert(Director director) {
		repository.insertDirector(director);
	}
	
	public void delete(String codString) {
		
		Director director = new Director();
		int cod = Integer.parseInt(codString);
		director.setCod(cod);
		repository.deleteDirector(director);
	}

}