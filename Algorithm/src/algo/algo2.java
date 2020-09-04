package algo;

import java.util.Arrays;

public class algo2 {
	public static void main(String[] args) {
		solution(112345);
	}
	
    public static int[] solution(long n) {
        String m = String.valueOf(n);
        String [] ms = m.split("");
        int[] answer = new int [ms.length];
       
        for(int i=0;i<ms.length;i++) {
        	answer[i] = Integer.parseInt(ms[(ms.length-(i+1))]);
        }
        
        return answer;
    }
	
}
