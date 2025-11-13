import java.util.*;
public class FibonacciSeries {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int a=0, b=1;
		System.out.println(a);
		System.out.println(b);
		for (int i=0;i<n-2;i++) {
			System.out.println(a+b);
			int t=a+b;
			a=b;
			b=t;
		}
	}
}
