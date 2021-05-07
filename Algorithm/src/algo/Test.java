package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		int i = Solution.solution("cdcd");

		System.out.println(i);
	}
}

class Solution {
	public static int solution(String s) {
		int answer = 0;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek()==c) stack.pop();
			else {
				stack.push(c);
			}
		}
		
		if(stack.size() == 0) {
			answer = 1;
		}
		

		return answer;
	}
}
