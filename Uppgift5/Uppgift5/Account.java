package Uppgift5;

import java.util.ArrayList;

public class Account {

	private Double deposit;
	private Double withdraw;	
	private Double saldo = 0.0;
	private int accountNumber;
	private String password;
	private ArrayList<Double> saldoList = new ArrayList<Double>();
	private int accNum;
	
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

	public void setSaldo(double saldo) {				
		this.saldo = saldo;
	}

}
