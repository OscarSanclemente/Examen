package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Film;
import es.salesianos.repository.FilmRepository;

public class FilmService {


	private FilmRepository repository = new FilmRepository();

	public List<Film> selectAllFilms() {
		return repository.selectAllFilms();
	}
	
	public void insertFilm(Film film) {
		repository.insertFilm(film);
		
	}
	
	public void deleteFilm(Film film) {
		repository.deleteFilm(film);
		
	}

}