import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Car Model(Delta/Alpha/Beta) : ");
		String model = sc.nextLine();
		double cost;
		switch (model) {
		case "Delta":
			cost = 800000;
			break;
		case "Alpha":
			cost=1200000;
			break;
		case "Beta":
			cost=1000000;
			break;
		default:
			System.out.println("Invalid Model");
			return;
		}
		
		System.out.print("Car color : ");
		String color=sc.nextLine();
		Car car = new Car(model,color,cost);
		
		System.out.print("Down Payment Amount : ");
		double down = sc.nextDouble();
		
		
		System.out.print("Interest Rate : ");
		double rate = sc.nextDouble();
		
		System.out.print("Time : ");
		int time = sc.nextInt();
		
		Loan loan =new Loan(car.getCost()-down,rate,time);
		
		System.out.println("Simple Interest : Rs"+loan.calculateSI());
		System.out.println("Total Amount after "+time+"yrs (SI) : Rs"+loan.calculateTotalPaymentSI());
		System.out.println("EMI (SI) : Rs"+loan.calculateEMISI()+"/month");
		
		System.out.println("Compound Interest : Rs"+loan.calculateCI());
		System.out.println("Total Amount after "+time+"yrs (CI) : Rs"+loan.calculateTotalPaymentCI());

	}
}
