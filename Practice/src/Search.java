import java.util.*;
public class Search {
	public static int linearSearch(ArrayList<Integer> arr,int n) {
		for(int i=0;i<arr.size();i++) {
			if (arr.get(i)==n) return i;
		}
		return -1;
	}
	
	public static int binarySearch(ArrayList<Integer> arr,int n) {
		Collections.sort(arr);
		int l=0,h=arr.size()-1;
		while(l<=h) {
			int m=(l+h)/2;
			if(arr.get(m)==n) return m;
			else if (arr.get(m)<n) l=m+1;
			else h=m-1;
		}
		return -1;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,6,7,17,29,31,67,89,101));
		System.out.println(linearSearch(arr,8));
		System.out.println(linearSearch(arr,17));
		System.out.println(binarySearch(arr,8));
		System.out.println(binarySearch(arr,17));

	}
}
