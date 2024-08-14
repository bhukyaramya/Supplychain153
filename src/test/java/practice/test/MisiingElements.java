package practice.test;

import java.util.ArrayList;

public class MisiingElements {

	public static void main(String[] args) {
		int[] a= {1,  3, 5, 6, 10 };
//		int n = 10; // The range is from 1 to n
//		findMissingElements(array, n);
//	}
//
//	public static void findMissingElements(int[] array, int n) {
//		// Step 1: Create a boolean array to mark the presence of elements
//		boolean[] present = new boolean[n + 1]; // Index 0 will be ignored
//
//		// Step 2: Mark the elements present in the input array
//		for (int num : array) {
//			present[num] = true;
//		}
//
//		// Step 3: Identify and print the missing elements
//		System.out.println("Missing elements are:");
//		for (int i = 1; i <= n; i++) {
//			if (!present[i]) {
//				System.out.print(i + " ");
//			}
//		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++) {
			al.add(a[i]);
		}
		for(int i=1;i<=10;i++) {
			if(!al.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
