package kz.kerey.business.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Good {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String name;

	@Column(unique=true, nullable=false)
	private String primaryBarcode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private GoodType type;
	
	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimaryBarcode() {
		return primaryBarcode;
	}

	public void setPrimaryBarcode(String primaryBarcode) {
		this.primaryBarcode = primaryBarcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
