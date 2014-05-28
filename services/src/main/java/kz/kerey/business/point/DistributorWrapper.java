package kz.kerey.business.point;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.points.Distributor;

@XmlRootElement
public class DistributorWrapper extends PointWrapper {

	private String bin;
	private String bankAccount;
	private String bankAccountDescription;
	
	public static Distributor toEntity(DistributorWrapper obj) {
		Distributor res = new Distributor();
		PointWrapper.toEntity(res, obj);
		res.setBankAccount(obj.getBankAccount());
		res.setBankAccountDescription(obj.getBankAccountDescription());
		res.setBin(obj.getBin());
		return res;
	}
	
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankAccountDescription() {
		return bankAccountDescription;
	}
	public void setBankAccountDescription(String bankAccountDescription) {
		this.bankAccountDescription = bankAccountDescription;
	}

}