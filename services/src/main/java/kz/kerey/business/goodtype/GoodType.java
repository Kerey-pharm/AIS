package kz.kerey.business.goodtype;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodType {

	private Long id;
	private String name;

	public static GoodType fromEntity(kz.kerey.business.types.GoodType obj) {
		if (obj!=null){
			GoodType res = new GoodType();
			res.setId(obj.getId());
			res.setName(obj.getName());
			return res;
		}
		return null;
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

}
