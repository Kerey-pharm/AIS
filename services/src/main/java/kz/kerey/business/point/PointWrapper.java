package kz.kerey.business.point;

public class PointWrapper {

	private Long id;
	private String name;
	private String description;
	private LocationWrapper location;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocationWrapper getLocation() {
		return location;
	}
	public void setLocation(LocationWrapper location) {
		this.location = location;
	}

}
