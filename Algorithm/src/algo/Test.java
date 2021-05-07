package algo;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		int i = Solution.solution("baabaa");
	
		System.out.println(i);
	}
}

class Solution {
    public static int solution(String s)
    {
        int answer = 0;

        // 원본 문자열
        char [] originArr = s.toCharArray();
        Queue<Character> ori = new LinkedList<Character>();
        Queue<Character> temp = new LinkedList<Character>();

        for(char item : originArr) {
        	ori.add(item);
        }
        
        // 입력된 문자열 길이가 홀수인 경우 무조건 0 반환 
        if(s.length()%2 != 0) {
        	return answer = 0;
        }
        
        // 큐에서 첫번째 인덱스와 두번째 인덱스 비교
        while(ori.size() > 1) {
        	char a = ori.poll();
        	char b = ori.peek();
        	
        	if(a != b){
        		temp.offer(a);
        	} else {
        		ori.poll();
        	}
        	
        	// 문자열의 탐색이 모두 끝났고, 임시 문자열이 남아있을 경우 - 반복
        	if(ori.isEmpty() && !temp.isEmpty()) {
        		ori.addAll(temp);
        		temp.clear();
        	}
        	
        	// 문자가 하나만 남았을 경우 - 리턴 0
        	if(ori.size()==1 && temp.isEmpty()) {
        		return 0;
        	}
        	
        	// 문자열이 하나 남았고, 임시 문자열이 남아있을 경우 - 반복할 수 없으므로 합치고 검증
        	if(ori.size()==1 && !temp.isEmpty()) {
        		temp.addAll(ori);
        		ori.clear();
        		ori.addAll(temp);
        		temp.clear();
        		
        		if(ori.size() == 1) {
        			return 0;
        		}
        		
        		if(!deletableCheck(ori)) {
        			return 0;
        		}
        		
        	}

        	
        }
        
        if(ori.isEmpty()) {
        	answer = 1;
        }
        
        return answer;
    }
    
    public static boolean deletableCheck(Queue<Character> q) {
    	boolean result = false;
    	
    	while(q.size() > 1) {
    		char a = q.poll();
    		char b = q.peek();
    		
    		if(a == b) {
    			return true;
    		}
    	}
    	
    	return result;
    }
}
