package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Film;

@Repository
public class FilmRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

	private static final Logger log = LogManager.getLogger(FilmRepository.class);
	
	public void insertFilm(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO FILM (tittle, codOwner) VALUES (?, ?)");
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setInt(2, film.getCodDirector());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("Error a la hora de insertar una pelicula "+e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void deleteFilm(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM FILM WHERE cod=?");
			preparedStatement.setInt(1, film.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("Error a la hora de borrar una pelicula "+e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public List<Film> selectAllFilms() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Film> list = new ArrayList<Film>();
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM FILM");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setCod(resultSet.getInt(1));
				film.setTitle(resultSet.getString(2));
				film.setCodDirector(resultSet.getInt(3));
				list.add(film);
			}
			
		} catch (SQLException e) {
			log.error("Error a la hora de cargar la lista de peliculas "+e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}
	
}
