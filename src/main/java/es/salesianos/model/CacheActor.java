package es.salesianos.model;

public class CacheActor extends Director{

	
	private Integer cache;
	private Integer codFilm;
	private Integer codActor;
	private String role;
	
	public Integer getCache() {
		return cache;
	}
	public void setCache(Integer cache) {
		this.cache = cache;
	}
	public Integer getCodFilm() {
		return codFilm;
	}
	public void setCodFilm(Integer codFilm) {
		this.codFilm = codFilm;
	}
	public Integer getCodActor() {
		return codActor;
	}
	public void setCodActor(Integer codActor) {
		this.codActor = codActor;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}
