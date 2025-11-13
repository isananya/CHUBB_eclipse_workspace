package process;

public class BankAccount {

	private int balance;

	public BankAccount(int initialBalance) {
		this.balance = initialBalance;
	}

	public synchronized void withdraw(int amount, String user) {

		System.out.println(user + " trying to withdraw rs" + amount);

		if (balance >= amount) {
			System.out.println(user + " processing..");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			balance -= amount;
			System.out.println(user + " completed withdrawal. Remaining balance: rs" + balance);
		} else {
			System.out.println(user + " cannot withdraw rs" + amount + " (Insufficient balance: rs" + balance + ")");
		}
	}

	public int getBalance() {
		return balance;
	}
}
