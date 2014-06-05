package kz.kerey.business.wrappers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DistributorWrapper extends PointWrapper {

	private String bin;
	private String bankAccount;
	private String bankAccountDescription;
	
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