package performance;

public class Worker implements Runnable {

	@Override
	public void run() {
		add(1,2);
	}
	
	int add(int a, int b) {
		return a+b;
	}

}
