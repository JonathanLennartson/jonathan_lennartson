package Uppgift5;

import java.util.ArrayList;

public class Account {

	private int accountNumber;
	private String password;
	private ArrayList<Double> withdraw = new ArrayList<Double>();
	private ArrayList<Double> deposit = new ArrayList<Double>();
	private ArrayList<Double> saldo = new ArrayList<Double>();
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

	public ArrayList<Double> getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double sumToWithdraw, ArrayList<Double> saldoList) {
		try {
			double saldo = saldoList.get(saldoList.size() - 1);

			if ((saldo - sumToWithdraw) < 0) {
				System.out.println("Finns inte tillräckligt med pengar");
			} else {
				this.withdraw.add(sumToWithdraw);
//				SaldoList.getList().
			}
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Finns inga pengar på kontot");
		}
	}

	public ArrayList<Double> getDeposit() {
		return deposit;
	}

	public void setDeposit(double sumToAdd) {
		this.deposit.add(sumToAdd);
	}

	public ArrayList<Double> getSaldo() {
		return saldo;
	}

	public void setSaldo(ArrayList<Double> deposit, ArrayList<Double> withdraw) {
		double sumDeposit = 0;
		double sumWithdraw = 0;

		try {
			for (double value : deposit) {
				sumDeposit = sumDeposit + value;
			}
			for (double value : withdraw) {
				sumWithdraw = sumWithdraw + value;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Lista för uttag är tom. Inga uttag gjorda ännu");
		}

		this.saldo.add(sumDeposit - sumWithdraw);
	}

}
