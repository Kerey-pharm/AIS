package kz.kerey.business.wrappers;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodItemWrapper implements Serializable {

	private static final long serialVersionUID = 6827601736927070247L;
	
	private Long id;
	private GoodItemWrapper parent;
	private GoodWrapper good;
	private String barcode;
	private String serial;
	private Date initialDate;
	private Date expireDate;
	private Long initialBoxCount;
	private Long initialCount;
	private Long currentCount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public GoodItemWrapper getParent() {
		return parent;
	}
	public void setParent(GoodItemWrapper parent) {
		this.parent = parent;
	}
	public GoodWrapper getGood() {
		return good;
	}
	public void setGood(GoodWrapper good) {
		this.good = good;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Long getInitialBoxCount() {
		return initialBoxCount;
	}
	public void setInitialBoxCount(Long initialBoxCount) {
		this.initialBoxCount = initialBoxCount;
	}
	public Long getInitialCount() {
		return initialCount;
	}
	public void setInitialCount(Long initialCount) {
		this.initialCount = initialCount;
	}
	public Long getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Long currentCount) {
		this.currentCount = currentCount;
	}
	
}
