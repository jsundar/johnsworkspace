package com.test.coditity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/***
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, 
 * except for one element that is left unpaired. For example, in array A such that:
 *   A[0] = 9  A[1] = 3  A[2] = 9 
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9 
 *   the elements at indexes 0 and 2 have value 9, 
 *   the elements at indexes 1 and 3 have value 3,
 *   the elements at indexes 4 and 6 have value 9,
 *   the element at index 5 has value 7 and is unpaired.
 *   Write a function: class Solution { public int solution(int[] A); } that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element. 
 *   For example, given array A such that:
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9 the function should return 7, as explained in the example above. 
 *   Write an efficient algorithm for the following assumptions: N is an odd integer within the range [1..1,000,000]; each element of array A is an integer within the range [1..1,000,000,000]; 
 *   all but one of the values in A occur an even number of times.
 * 
 * @author JOHN SUNDAR
 *
 */
public class OddOccurrencesInArray {
	
	public int[] findPairedElements(int[] A) {
		int size = A.length;
		int[] B = new int[size];
		int k = 0;
		for(int i = 0; i< size-1;i++) {
			boolean isexist = false;
			for(int j = 0; j < size; j++) {
				if(i==j) continue;
				if(A[i] == A[j]) {
					isexist = true;
				}
			}
			if(!isexist) {
				B[k] = A[i];
				k++;
			}
		}
		return B;
				
	}
	
	public Map<Integer, Integer> findPairedElements1(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < A.length; i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i])+1);
			} else {
				map.put(A[i], Integer.valueOf(1));
			}
		}
		
		return map;
	}
	public int[] getFind(int[] A) {
		Map<Integer, Integer> map = findPairedElements1(A);
		int[] B = new int[map.size()];
		int i=0;
		for(Entry entry : findPairedElements1(A).entrySet()) {
			if(entry.getValue().equals(1)) {
				B[i]=(int) entry.getKey();
				i++;
			}
		}
		return B;
	}
	public static void main(String[] args) {
		OddOccurrencesInArray obj = new OddOccurrencesInArray();
		int[] A = new int[] {9,3,9,3,7,9};
		int[] B = obj.getFind(A);
		for(int i = 0; i < B.length;i++) {
			if(B[i] !=0)
			System.out.println(B[i]);
		}
	}

}
