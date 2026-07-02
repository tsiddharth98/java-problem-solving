package utils;

import java.util.Scanner;

public class Utils {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int[] getIntArray() {
	
		System.out.println("Enter array size: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter array values:");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("array values:");
		printArray(arr);
		System.out.println("");
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		int x= arr[i];
		arr[i] = arr[j];
		arr[j] = x;
	}

	public static void printArray(int[] arr) {
		int size = arr.length;
		System.out.print("arr: ");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	
	
	
}
