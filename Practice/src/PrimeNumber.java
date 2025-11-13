
public class PrimeNumber {
	public static void main(String[] args) {
		for(int i = 2;i<=500;i++) {
			boolean p = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					p=false;
					break;
				}
			}
			if(p==true) System.out.println(i);
				
		}
	}
}
