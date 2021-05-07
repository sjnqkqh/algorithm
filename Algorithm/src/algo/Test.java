package algo;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		int i[] = { 70, 50, 80, 50 };

		int r = Solution.solution(i, 100);
		System.out.println(r);

	}
}

class Solution {
	static LinkedList<Integer> q = new LinkedList<Integer>();
	static int answer = 0;

	public static int solution(int[] people, int limit) {

		// 사전 처리
		Arrays.sort(people);
		for (int item : people) {
			q.add(item);
		}

		Solution.help(limit);

		return answer;
	}

	// 무거운 놈들부터 구하고, 구할 사람 남으면 재귀
	public static void help(int limit) {

		int man = q.removeLast();
		int can = limit - man;
		
		if(!q.isEmpty() && q.peek() <= can) {
			for (int i = q.size() - 1; i >= 0; i--) {
				if (q.get(i) <= can) {
					int guhal = q.get(i);
					can = can - guhal;
					q.removeLastOccurrence(guhal);
					break;
				}
			}
		}
		answer++;
		
		if(!q.isEmpty()) {
			help(limit);
		}
	}
}