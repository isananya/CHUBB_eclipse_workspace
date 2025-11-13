import java.util.*;
public class Sort {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1002,110,23445,6789,9807,6455,75));
		System.out.println("Original Array : "+arr);

		for(int i=1;i<arr.size();i++) {
			int x=arr.get(i);
			int j=i-1;
			while(j>=0 && arr.get(j)>x) {
				arr.set(j+1, arr.get(j));
				j--;
			}
			arr.set(j+1,x);
		}
		System.out.println("Sorted Array : "+arr);

	}
}
