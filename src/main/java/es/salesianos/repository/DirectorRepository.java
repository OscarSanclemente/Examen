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
import es.salesianos.model.Director;

@Repository
public class DirectorRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

	private static final Logger log = LogManager.getLogger(DirectorRepository.class);
	
	public void insertDirector(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO DIRECTOR (name) VALUES (?)");
			preparedStatement.setString(1, director.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("Error a la hora de insertar un director "+e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void deleteDirector(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM DIRECTOR WHERE cod=?");
			preparedStatement.setInt(1, director.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("Error a la hora de eliminar un director "+e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public List<Director> selectAllDirector() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Director> list = new ArrayList<Director>();
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM DIRECTOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Director director = new Director();
				director.setCod(resultSet.getInt(1));
				director.setName(resultSet.getNString(2));
				list.add(director);
			}
			
		} catch (SQLException e) {
			log.error("Error a la hora de cargar la lista de directores "+e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}
	
	public Director filterAllDirector(String name) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Director director = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT DIRECTOR.NAME" + " FROM (((ACTOR"
					+ " INNER JOIN FILMACTOR ON FILMACTOR.CODACTOR = ACTOR.COD)"
					+ " INNER JOIN FILM ON FILM.COD = FILMACTOR.CODFILM)"
					+ " INNER JOIN DIRECTOR ON DIRECTOR.COD = FILM.CODOWNER)" + " WHERE ACTOR.NAME = (?)");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Director directorfromDataBase = new Director();
				directorfromDataBase.setName(resultSet.getString(1));
				director = directorfromDataBase;
			}
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return director;
	}
	
}