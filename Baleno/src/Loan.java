
public class Loan {
	public double principal;
	public double rate;
	public int time;
	
	public Loan(double p,double r, int t) {
		this.principal=p;
		this.rate=r;
		this.time=t;
	}
	
	public double calculateSI() {
		return (principal*rate*time)/100;
	}
	
	public double calculateTotalPaymentSI() {
		return principal + calculateSI();
	}
	
	public double calculateEMISI() {
		return calculateTotalPaymentSI()/(time*12);
	}
	
	public double calculateCI() {
		return (principal * Math.pow((1+(rate/100)),time)) - principal;
	}
	public double calculateTotalPaymentCI() {
		return principal + calculateCI();
	}
	

}
