package kz.kerey.business.good.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.goodtype.wrapper.GoodType;

@XmlRootElement
public class Good {
	
	private Long id;
	private String name;
	private String primaryBarcode;
	private GoodType type;

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

	public String getPrimaryBarcode() {
		return primaryBarcode;
	}

	public void setPrimaryBarcode(String primaryBarcode) {
		this.primaryBarcode = primaryBarcode;
	}

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}

}
