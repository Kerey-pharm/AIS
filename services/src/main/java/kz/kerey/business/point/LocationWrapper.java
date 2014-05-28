package kz.kerey.business.point;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.points.Location;

@XmlRootElement
public class LocationWrapper {

	private Long id;
	private String name;
	
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
	
	public static LocationWrapper fromEntity(Location e) {
		LocationWrapper res = new LocationWrapper();
		res.setId(e.getId());
		res.setName(e.getName());
		return res;
	}
	
	public static Location toEntity(LocationWrapper w) {
		Location res = new Location();
		res.setId(w.getId());
		res.setName(w.getName());
		return res;
	}
	
}