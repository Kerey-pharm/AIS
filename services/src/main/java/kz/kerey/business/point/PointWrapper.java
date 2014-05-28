package kz.kerey.business.point;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.points.Point;

@XmlRootElement
public class PointWrapper {

	private Long id;
	private String name;
	private String description;
	private LocationWrapper location;
	
	public static void fromEntity(PointWrapper res, Point obj) {
		res.setDescription(obj.getDescription());
		res.setId(obj.getId());
		res.setName(obj.getName());
		res.setLocation(LocationWrapper.fromEntity(obj.getLocation()));
	}
	
	public static void toEntity(Point res, PointWrapper obj) {
		res.setDescription(obj.getDescription());
		res.setId(obj.getId());
		res.setName(obj.getName());
	}
	
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