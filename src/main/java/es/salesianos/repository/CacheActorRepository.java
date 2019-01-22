package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
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
}