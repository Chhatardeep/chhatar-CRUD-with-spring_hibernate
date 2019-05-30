package collection;

import java.util.Scanner;

public class binary {

	public static void bs(int arr[], int f, int l, int k) {
		int m = (f + l) / 2;
		while (f <= l) {
			if (arr[m] < k) {
				f = m + 1;
			} else if (arr[m] == k) {
				System.out.println("found at = " + m);
				break;
			} else {
				l = m - 1;
			}
			m = (f + l) / 2;
		}
	}

	/*
	 * int m = (f + l)/2; while( f <= l ){ if ( arr[m] < k ){ f = m + 1; }else if (
	 * arr[m] == k ){ System.out.println("Element is found at index: " + m); break;
	 * }else{ l = m - 1; } m = (f + l)/2; }
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int[] arr = new int[100];
		System.out.println("enter size of array");
		int n = s.nextInt();
		System.out.println("enter element of array");
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		System.out.println("enter key to find in array");

		int key = s.nextInt();
		int last = arr.length - 1;
		bs(arr, 0, last, key);

		/*
		 * int arr[] = { 10, 20, 30, 40, 50 }; int key = 40; int last = arr.length - 1;
		 * bs(arr, 0, last, key);
		 */

	}
}
