package com.test.coditity.rakutan;

public class TestJava {
	
	public static int findreversalCount(int[] A) {
		int count = 0;
		for(int i = 0; i< A.length; i++) {
			if(i<A.length-1 && A[i] == A[i+1]) {
				count++;
			} else if((i == (A.length - 1)) ) {
				if(A[i-1] == A[i]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int findPairs(int A[]) {
		int count =0; 
		boolean found = false;
		for(int i=0;i<A.length -1; i++) {
			if(A[i] == A[i+1]) {
				count++;
			} else if(((i+2) < A.length -1) && !found) {
				if((A[i] == 0 && A[i+1] == 1 && A[i+2] ==0)|| (A[i] == 1 && A[i+1] == 0 && A[i+2] ==1)) {
					found = true;
					//count = count + 2;
				} else if((A[i] == 1 && A[i+1] == 0 && A[i+2] ==0) || (A[i] ==0 && A[i+1] == 1 && A[i+2] == 1)) {
					found = true;
					count = count+1;
				}
			}
		}
		return count;
	}
	
	int solution(int[] A) {
		int leftMax = A[0];
		int maximum = A[0];
		int position =0;
		int n = A.length;
		for(int i= 0; i< n; i++) {
			if(A[i] < leftMax) {
				position = i+1;
				leftMax = maximum;
			} else if(A[i] > maximum) {
				maximum = A[i];
			}
		}
		return position;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,1, 0, 1, 1};
		//int[] afterReverse = new int[] {1,0,1,0,1,0};
		int count = findPairs(A);
		System.out.println(count);
	}

}
