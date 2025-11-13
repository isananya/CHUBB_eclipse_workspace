
public class Car {
	public String model;
	public String color;
	public double cost;
	
	public Car(String m, String col, double c) {
		this.model=m;
		this.color=col;
		this.cost=c;
	}

	public double getCost() {
		return cost;
	}
}
