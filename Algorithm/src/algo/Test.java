package algo;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		Solution.solution("cdcd");
	}
}

class Solution {
    public static int solution(String s)
    {
        int answer = 0;

        // 원본 문자열
        String [] originArr = s.split("");
        Queue<String> ori = new LinkedList<String>();
        Queue<String> temp = new LinkedList<String>();

        for(String item : originArr) {
        	ori.add(item);
        }
        
        // 입력된 문자열 길이가 홀수인 경우 무조건 0 반환 
        if(s.length()%2 != 0) {
        	return answer = 0;
        }
        
        // 큐에서 첫번째 인덱스와 두번째 인덱스 비교
        while(ori.size() > 1) {
        	String a = ori.poll();
        	String b = ori.peek();
        	
        	if(!a.equals(b)) {
        		temp.add(a);
        	} else {
        		ori.poll();
        	}

        	if(ori.isEmpty() && !temp.isEmpty()) {
        		ori.addAll(temp);
        		temp.clear();
        	}
        }
        
        if(ori.size() == 0) {
        	answer = 1;
        }
        
        return answer;
    }
    
    
}
