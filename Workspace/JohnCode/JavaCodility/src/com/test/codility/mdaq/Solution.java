package com.test.codility.mdaq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	String solution(String S) {
		int[] occurrences = new int[26];
		for (char ch : S.toCharArray()) {
			occurrences[ch - 'a']++;
		}

		char best_char = 'a';
		int best_res = 0;

		for (int i = 0; i < 26; i++) {
			if (occurrences[i] > best_res) {
				best_char = (char) ((int) 'a' + i);
				best_res = occurrences[i];
			}
		}
		int g = 0, max = 0;
		max = occurrences[0];
		for (int j = 1; j < 26; j++) {
			if (max < occurrences[j]) {
				max = occurrences[j];
				g = j;
			}
		}

		return Character.toString(best_char);
	}

	int findCount(int A, int B) {
		int count = 0;
		int i = 1;
		int calc = i * (i + 1);
		while (calc <= B) {

			if (calc >= A) {
				count++;
			}
			calc = i * (i + 1);
			i++;
		}
		return count;

	}

	String getMaxCharecters(int A, int B, int C) {
		int totalChar = A + B + C;
		StringBuffer bf = new StringBuffer();
		int charCount = 0;
		boolean isB = false;
		while (bf.length() < totalChar) {
			if (A != 0 && A >= 3 && A != 2 && A != 1) {
				bf.append("aa");
				A = A - 2;
				charCount = charCount + 2;
			} else if (A == 2) {
				bf.append("aa");
				A = 0;
				charCount = charCount + 2;
			} else {
				if (A != 0) {
					bf.append("a");
					A = 0;
					charCount = charCount + 1;
				}
			}

			if (B != 0 && B >= 3 && B != 2 && B != 1) {
				bf.append("bb");
				B = B - 2;
				charCount = charCount + 2;
				isB = true;
			} else if (B == 2) {
				bf.append("bb");
				B = 0;
				charCount = charCount + 2;
				isB = true;
			} else {
				if (B != 0) {
					bf.append("b");
					B = 0;
					charCount = charCount + 1;
					isB = true;
				} else {
					isB = false;
				}
			}

			if (C != 0 && C >= 3 && C != 2 && C != 1) {
				bf.append("cc");
				C = C - 2;
				charCount = charCount + 2;
			} else if (C == 2) {

				bf.append("cc");
				C = 0;
				charCount = charCount + 2;
			} else {
				if (C != 0) {
					bf.append("c");
					C = 0;
					charCount = charCount + 1;
				}
			}

		}
		return bf.toString();
	}

	/**
	 * UBS hackerrank
	 * @param text
	 * @return
	 */
	public static char maximumOccurringCharacter(String text) {
		// Write your code here
		String[] bigStr = new String[text.length()];
		int[] smallCase = new int[26];
		int[] upperCase = new int[26];
		int[] num = new int[10];
		for (char ch : text.toCharArray()) {
			if (Character.isDigit(ch)) {
				num[ch - '0']++;
			} else if (Character.isUpperCase(ch)) {
				upperCase[ch - 'A']++;
			} else {
				smallCase[ch - 'a']++;
			}

		}
		char max_schar = 'a';
		char max_bchar = 'A';
		int best_res = 0;
		int z = 0;
		for (int i = 0; i < 26; i++) {
			if (smallCase[i] > best_res) {
				max_schar = (char) ((int) 'a' + i);
				best_res = smallCase[i];
				bigStr[z++] = max_schar + "|" + best_res;
			}
			if (upperCase[i] > best_res) {
				max_bchar = (char) ((int) 'A' + i);
				best_res = upperCase[i];
				bigStr[z++] = max_bchar + "|" + best_res;
			}
		}
		char max_nchar = '0';
		for (int i = 0; i < 10; i++) {
			if (num[i] > best_res) {
				max_nchar = (char) ((int) '0' + i);
				best_res = num[i];
				bigStr[z++] = max_nchar + "|" + best_res;
			}
		}
		char result = 0;
		for (String s : bigStr) {
			if (s != null) {
				if (s.contains(String.valueOf(best_res))) {
					result = s.charAt(0);
				}
			}
		}

		return result;
	}
	/**
	 * UBS hackerrank
	 * @param products
	 * @param productPrices
	 * @param productSold
	 * @param soldPrice
	 * @return
	 */
	public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
		int errorCount = 0;
		Map<String, Float> productDetails = new HashMap<>();
		for(int i =0;i<products.size();i++) {
			productDetails.put(products.get(i), productPrices.get(i));
		}
		for(int i =0;i<productSold.size();i++) {
			Float price = productDetails.get(productSold.get(i));
			if(!price.equals(soldPrice.get(i))) {
				errorCount++;
			}
			
		}
		return errorCount;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		//System.out.println(sol.maximumOccurringCharacter("HelloMMM"));
		// System.out.println(sol.findCount(21, 29));
		// System.out.println(sol.getMaxCharecters(6, 1, 1));
		// 6,1,1
		// 1,3,1
		// 0,1,8
		
		List<String> products = new ArrayList<>();
		List<Float> productPrices = new ArrayList<>();
		products.add("eggs");
		products.add("milk");
		products.add("cheese");
		productPrices.add(2.89f);
		productPrices.add(3.29f);
		productPrices.add(5.79f);
		
		List<String> productSold = new ArrayList<>();
		productSold.add("milk");
		productSold.add("milk");
		productSold.add("cheese");
		List<Float> soldPrice = new ArrayList<>();
		soldPrice.add(2.89f);
		soldPrice.add(2.66f);
		soldPrice.add(5.79f);
		System.out.println(priceCheck(products, productPrices,productSold, soldPrice));
	}
}
