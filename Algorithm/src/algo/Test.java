package algo;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		String record[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		Solution.solution(record);

	}
}

class Solution {

	public static String[] solution(String[] record) {
		String[] answer = {};
		int ArrSize = record.length;
		HashMap<String, String> nickMap = new HashMap<String, String>();

		// 최종 별명 구하기
		for (String item : record) {
			String order[] = item.split(" ");
			String orderStr = order[0];		// 명령어
			String nameStr = order[1];		// 실제 아이디
			String nickStr = "";			// 사용중인 닉네임
			if (order.length == 3)	nickStr = order[2];

			switch (orderStr) {
			case "Enter":
				nickMap.put(nameStr, nickStr);
				break;
				
			case "Change":
				nickMap.put(nameStr, nickStr);
				ArrSize--;
				break;
			}
		}

		// 히스토리 남기기
		answer = new String [ArrSize];
		int index = 0;

		for(int i=0; i<record.length; i++) {
			String item = record[i];
			String log = "";
			
			String order[] = item.split(" ");
			String orderStr = order[0];
			String nameStr = order[1];
			
			
			switch (orderStr) {
			case "Enter":
				log = nickMap.get(nameStr)+"님이 들어왔습니다.";
				answer[index] = log;
				index++;
				break;
				
			case "Leave":
				log = nickMap.get(nameStr)+"님이 나갔습니다.";
				answer[index] = log;
				index++;
				break;
			}
			
		}
		
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}