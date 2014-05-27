package kz.kerey.business.types.points;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Distributor")
public class Distributor extends Point {

	@Column(unique=true, nullable=false)
	private String bin;
	
	@Column
	private String bankAccount;
	
	@Column
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
