package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		System.out.println(Solution.solution("aaabbab"));
	}
}

class Solution {
    public static int solution(String s)
    {
        int answer = 0;

        // 원본 문자열
        String [] originArr = s.split("");
        ArrayList<String> originList = new ArrayList<String>(Arrays.asList(originArr));
        ArrayList<String> newList = new ArrayList<String>();
        
        while(originList.size() > 1) {
	        for(int i=0; i+1<originList.size(); i++) {
	        	String a = originList.get(i);		// 인덱스에 해당하는 문자
	        	String b = originList.get(i+1);		// 인덱스 다음 문자
	        	
	        	if(!a.equals(b)) { 	// a와 b가 다른 경우 - 해당 문자는 유지되어야 함
	        		newList.add(a);
	        		break;
	        	} else {			// a와 b가 같은 경우 - 해당 문자열과 다음 문자열은 넘어가야 함.
	        		i= i+1;
	        	}
	        }
	        
	        // 문자열 대조 결과를 저장하고, 임시 리스트는 초기화
	        originList = (ArrayList<String>) newList.clone();	
	        newList.clear();
        }
        
         if(originList.size()==0) {
        	 answer = 1;
         }
    
        return answer;
    }
    
    
}
