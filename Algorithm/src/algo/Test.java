package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";

		Solution.solution(s);
	}
}

class Solution {

	public static int solution(String s) {
		int answer = s.length();
		int max = s.length()/2;
		
		for(int i=1; i<=max ;i++) {
			ArrayList<String> strArray = cut(s, i);
			String zipedStr = duplicationCheck(strArray);
			
			if(zipedStr.length() < answer) {
				answer = zipedStr.length();
			}
		}
		
		return answer;
	}
	
	// 문자열 쪼개기
	public static ArrayList<String> cut(String s, int range) {
		ArrayList<String> result = new ArrayList<String>();
		int strLength = s.length();
		
		for(int i=0; i<strLength; i++) {
			int startNum = i*range;
			int endNum	 = (startNum+range > strLength)? strLength : startNum+range;

			if(startNum >= strLength || endNum > strLength) {
				break;
			}else {
				String str = s.substring(startNum, endNum);
				result.add(str);
			}
		}
		return result;
	}
	
	// 배열 순차탐색하면서 동일한 인자값 존재하는지 확인 후 문자열을 생성해 반환
	public static String duplicationCheck(ArrayList<String> strArray){
		Queue<String> strQueue = new LinkedList<String>();
		int duplicationCount = 1;
		String result = "";
		
		for(int i=0; i<strArray.size()-1; i++) {
			String a = strArray.get(i);
			String b = strArray.get(i+1);
			
			// A와 B가 같은 경우
			// A-1. 해당 인덱스가 마지막 인덱스 (size()-2) 일 경우		=> 압축 후 큐에 삽입
			// A-2. 해당 인덱스가 마지막 인덱스가 아닐 경우				=> 압축;
			
			// A와 B가 다른 경우
			// B-1. 해당 인덱스가 마지막 인덱스 (size()-2) 일 경우		=> A와 B 모두 큐에 삽입
			// B-2. 해당 인덱스가 마지막 인덱스가 아닐 경우				=> A만 큐에 삽입
			
			// A-1
			if(a.equals(b) && i==strArray.size()-2) {
				duplicationCount++;
				strQueue.offer(String.valueOf(duplicationCount));
				strQueue.offer(a);
				duplicationCount = 1; // 압축횟수 초기화
			}
			
			// A-2
			if(a.equals(b) && i!=strArray.size()-2) {
				duplicationCount++;
			}
			
			// B-1
			if(!a.equals(b) && i==strArray.size()-2) {
				strQueue.offer(String.valueOf(duplicationCount));
				strQueue.offer(a);
				strQueue.offer(b);
			}
			
			// B-2
			if(!a.equals(b) && i!=strArray.size()-2) {
				strQueue.offer(String.valueOf(duplicationCount));
				strQueue.offer(a);
				duplicationCount = 1; // 압축횟수 초기화
			}
		}

		// 문자열로 변환
		for(String item : strQueue) {
			if(!item.equals("1")) result = result + item;
		}
		
		return result;
	}
}