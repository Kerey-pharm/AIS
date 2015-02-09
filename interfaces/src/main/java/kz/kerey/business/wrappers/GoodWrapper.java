package kz.kerey.business.wrappers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodWrapper implements Serializable {
	
	private static final long serialVersionUID = 9193164450976229712L;
	
	private Long id;
	private String name;
	private String primaryBarcode;
	private Boolean partialSelling;
	private Long countPerBox;
	private Long countSellable;
	
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
	public Boolean getPartialSelling() {
		return partialSelling;
	}
	public void setPartialSelling(Boolean partialSelling) {
		this.partialSelling = partialSelling;
	}
	public Long getCountPerBox() {
		return countPerBox;
	}
	public void setCountPerBox(Long countPerBox) {
		this.countPerBox = countPerBox;
	}
	public Long getCountSellable() {
		return countSellable;
	}
	public void setCountSellable(Long countSellable) {
		this.countSellable = countSellable;
	}

	@Override
	public String toString() {
		return this.name + " ("+this.primaryBarcode+")";
	}
	
}
