package Uppgift5;

public class Account {

	private Double deposit;
	private Double withdraw;	
	private Double saldo;
	private int accountNumber;
	private String password;
	private int accNum;
	private Object dateTime;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber(String userName) {
		for (char c : userName.toCharArray()) {
			accNum = accNum + c;
		}
		accountNumber = accNum;		
		return accountNumber;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {		
			this.withdraw = withdraw;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {			
		this.deposit = deposit;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {				
		this.saldo = saldo;
	}

	public Object getDateTime() {
		return dateTime;
	}

	public void setDateTime(Object dateTime) {
		this.dateTime = dateTime;
	}

}
