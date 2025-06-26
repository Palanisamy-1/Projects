package model;

public class Account {
	private int accno;
	private String accholder;
	private double accbalance;
	public Account(int id,String name,double amount) {
		this.accno=id;
		this.accholder=name;
		this.accbalance=amount;
	}
	public int getAccno() {
		return accno;
	}
	public String getAccholder() {
		return accholder;
	}
	public double getBalance() {
		return accbalance;
	}
	

}
