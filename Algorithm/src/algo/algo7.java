package algo;

import java.util.Stack;

public class algo7 {
	public static void main(String[] args) {
		//https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
		int [] prices = {1,2,3,2,3};
		solution(prices);
	}

    public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> down = new Stack<Integer>();
		int leng = 0;
		
		for(int i=0; i<prices.length;i++) {
			leng = 0;
			for(int j=i;j<prices.length;j++) {
				leng++;
				if(prices[i]>prices[j] || j==prices.length-1) {
					down.push(leng-1);
					break;
				} 			
			}
		}
		
		for(int k=0;k<down.size();k++) {
			answer[k] = down.get(k);
		}
		
		return answer;
	}
}
