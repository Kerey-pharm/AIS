package kz.kerey.business.wrappers;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.Good;

@XmlRootElement
public class GoodWrapper {
	
	private Long id;
	private String name;
	private String primaryBarcode;
	private Boolean partialSelling;
	private Long countPerBox;
	private Long countSellable;
	private GoodTypeWrapper type;

	public static GoodWrapper fromEntity(Good obj) {
		GoodWrapper res = new GoodWrapper();
		res.setCountPerBox(obj.getCountPerBox());
		res.setCountSellable(obj.getCountSellable());
		res.setName(obj.getName());
		res.setPartialSelling(obj.getPartialSelling());
		res.setPrimaryBarcode(obj.getPrimaryBarcode());
		res.setId(obj.getId());
		res.setType(GoodTypeWrapper.fromEntity(obj.getType()));
		return res;
	}
	
	public static Good toEntity(GoodWrapper obj) {
		Good res = new Good();
		res.setCountPerBox(obj.getCountPerBox());
		res.setCountSellable(obj.getCountSellable());
		res.setName(obj.getName());
		res.setPartialSelling(obj.getPartialSelling());
		res.setPrimaryBarcode(obj.getPrimaryBarcode());
		return res;
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

	public String getPrimaryBarcode() {
		return primaryBarcode;
	}

	public void setPrimaryBarcode(String primaryBarcode) {
		this.primaryBarcode = primaryBarcode;
	}

	public GoodTypeWrapper getType() {
		return type;
	}

	public void setType(GoodTypeWrapper type) {
		this.type = type;
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

}
