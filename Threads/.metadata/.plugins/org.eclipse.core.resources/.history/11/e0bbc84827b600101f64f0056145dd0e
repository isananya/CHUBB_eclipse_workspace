package process;

public class WorkerThread implements Runnable {

	BankAccount account;
	String user;
	int amount;

	public WorkerThread(BankAccount acc, String user, int amount) {
		this.account = acc;
		this.user = user;
		this.amount = amount;
	}

	@Override
	public void run() {

		account.withdraw(amount, user);

		System.out.println("Inside run() for " + user);
	}
}

