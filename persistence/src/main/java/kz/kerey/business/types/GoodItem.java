package kz.kerey.business.types;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GoodItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private GoodItem parent;
	
	@ManyToOne
	private Good good;
	
	@Column(unique=true, nullable=false)
	private String barcode;
	
	@Column(nullable=false)
	private String serial;
	
	@Column(nullable=false)
	private Date initialDate;
	
	@Column(nullable=false)
	private Date expireDate;
	
	@Column(nullable=false)
	private Long initialBoxCount;
	
	@Column(nullable=false)
	private Long initialCount;
	
	@Column(nullable=false)
	private Long currentCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
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

	public GoodItem getParent() {
		return parent;
	}

	public void setParent(GoodItem parent) {
		this.parent = parent;
	}

}