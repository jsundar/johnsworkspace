package com.test;

import java.util.StringTokenizer;

public class RemoveDuplicateString {
	
	public static void main(String[] args) {
		String paraString = "How do you want to join your Teams meeting How do you want to join your teams meeting";
		int[] A= new int []{-3,-14,-5,7,8,42,8,3};  //{6, 42, 11, 7, 1, 42};
		
		System.out.println(highestTemp(A)); //45546378
		//System.out.println(solution1(paraString));
	}
	
	static int solution1(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }
	
	enum SEASON {
		WINTER(0,"WINTER"),
		SPRING(1,"SPRING"),
		SUMMER(2,"SUMMER"),
		AUTUMN(3,"AUTUMN");
		private int id;
		private String seasonName;
		
		SEASON(int id, String seasonName) {
			this.setId(id);
			this.setSeasonName(seasonName);
		}
		
		
		public static String getseasonName(int id) {
			String seasonName = null;
			if(id == 0) {
	        	seasonName = "WINTER";
	        }
	        if(id == 1) {
	        	seasonName = "SPRING";
	        }
	        if(id == 2) {
	        	seasonName = "SUMMER";
	        }
	        if(id == 3) {
	        	seasonName = "AUTUMN";
	        }
	        return seasonName;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getSeasonName() {
			return seasonName;
		}


		public void setSeasonName(String seasonName) {
			this.seasonName = seasonName;
		}
		
    }
	public static String highestTemp(int[] T) {
		
		int n = T.length/4;
		int arrsize = T.length/n;
        int z=0;
        int mintemp = 0;
        int maxtemp = 0;
        
        int[] amplitude = new int[arrsize];
        int j =0;
        while(z<T.length) {
        	for(int i=0; i<n; i++) {
        		if(i==0) {
        			mintemp =  T[z];
        			maxtemp = T[z];
        		}
        		mintemp = mintemp > T[z] ? T[z] : mintemp;
        		maxtemp = maxtemp > T[z] ? maxtemp:T[z] ;
        		z++;
        	}
        	amplitude[j] = maxtemp - mintemp;
        	j++;
        	
        }
        int big = amplitude[0];
        int bigger = 0;
        for(int i=1;i<amplitude.length;i++) {
        	if(amplitude[i] > big) {
        		big = amplitude[i];
        		bigger = i;
        	}
        }
        
		return SEASON.getseasonName(bigger);
            
		
	}
	
	public static  int solution2(String S) {
        // write your code in Java SE 8
		
		String str = S;
		while((S.contains("aaa") || S.contains("bbb"))) {
			if(S.contains("aaa") || S.contains("bbb")) {
				str = S.charAt(0) == 'a' ? S : S.substring(1, S.length()-1);
			}
			S = str.replace("aaa","aa").replace("bbb","bb");
		}
				
        return S.length();
    }

	public static int solution(int A) {
        // write your code in Java SE 8
        String str = String.valueOf(A);
        int n = str.length() ;
        StringBuffer returnInt = new StringBuffer("");
        int j = n-1;
        for(int i=0;i<=n/2;i++) {
            returnInt = returnInt.append(str.charAt(i)).append((j > (n/2) ? String.valueOf(str.charAt(j)) : ""));
            j--;
        }
        return Integer.parseInt(returnInt.toString());
    }
	public static String removeDuplicate(String paraString) {
		StringTokenizer tokens = new StringTokenizer(paraString, " ");
		StringBuffer newString = new StringBuffer();
		while(tokens.hasMoreElements()) {
			String tempStr = tokens.nextToken();
			if(newString!= null && !newString.toString().toUpperCase().contains(tempStr.toUpperCase())) {
				newString.append(tempStr);
				newString.append(" ");
			}
		}
		return newString.toString();
	}
	
	
	
	
}
