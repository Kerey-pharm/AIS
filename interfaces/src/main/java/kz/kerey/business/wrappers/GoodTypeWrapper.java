package kz.kerey.business.wrappers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodTypeWrapper implements Serializable {

	private static final long serialVersionUID = 6383460048361347080L;
	
	private Long id;
	private String name;

	public GoodTypeWrapper() {}
	
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

	@Override
	public String toString() {
		if (this.getId()!=null && this.getId()!=0)
			return this.getName();
		return "ПУСТО";
	}
	
}
