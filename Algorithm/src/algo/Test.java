package algo;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String s = "110010101001";
		
		Solution.solution(s);
	}
}

class Solution {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int deleted = 0, deleteCount = 0;
        String remain = s;
        
        while(!remain.equals("1")) {
	        String [] arr = remain.split("");
	        Arrays.sort(arr);
	
	        int i=0;
	        while(arr[i].equals("0")) {
	        	deleted++;
	        	i++;
	        }
	        
	        
	        remain = Integer.toBinaryString(arr.length-i);
	        deleteCount++;
        }
        answer[0] = deleteCount;
        answer[1] = deleted;
        
        return answer;
    }
}
