package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Actor;
import es.salesianos.model.CacheActor;

public class CacheActorRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

	public void insertCacheActor(CacheActor cacheActor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO FILMACTOR (CACHE, ROLE, CODACTOR, CODFILM)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, cacheActor.getCache());
			preparedStatement.setString(2, cacheActor.getRole());
			preparedStatement.setInt(3, cacheActor.getCodActor());
			preparedStatement.setInt(4, cacheActor.getCodFilm());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public Actor selectActor(String role){
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Actor> list = new ArrayList<Actor>();
		try {
			preparedStatement = conn.prepareStatement("SELECT TITTLE, NAME, YEAROFBIRTHDATE" + " FROM ((FILMACTOR"
					+ " INNER JOIN FILM ON FILM.COD = FILMACTOR.CODFILM)"
					+ " INNER JOIN ACTOR ON ACTOR.COD = FILMACTOR.CODACTOR)" + " WHERE FILMACTOR.ROLE = (?)");
			preparedStatement.setString(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setTitle(resultSet.getString(1));
				actor.setName(resultSet.getString(2));
				actor.setYear(resultSet.getInt(3));
				actor = dtofromDataBase;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}
}