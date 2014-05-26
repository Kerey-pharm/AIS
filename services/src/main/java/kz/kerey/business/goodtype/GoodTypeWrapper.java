package kz.kerey.business.goodtype;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodTypeWrapper {

	private Long id;
	private String name;

	public static GoodTypeWrapper fromEntity(kz.kerey.business.types.GoodType obj) {
		if (obj!=null){
			GoodTypeWrapper res = new GoodTypeWrapper();
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
