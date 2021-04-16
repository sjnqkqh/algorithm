package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int n = 45;
		
		System.out.println(Solution.solution(n));
		
	}
}

class Solution {
	public static int solution(int n) {
		int answer = 0;
		int radix = 3; 
		String convertedStr = "";
		String reversedStr = "";
		
		while(n > 0) {
			int quotient = n / radix;
			int remainder = n % radix;
			convertedStr = remainder + convertedStr;
			n = quotient;
		}
		
		ArrayList<String> tempArr = new ArrayList<String>(Arrays.asList(convertedStr.split("")));
		for(int i=0; i<tempArr.size(); i++) {
			reversedStr = tempArr.get(i)+reversedStr;
		}
		
		answer = Integer.valueOf(reversedStr, 3);
		
		return answer;
	}
}
