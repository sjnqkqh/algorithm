package algo;

import java.util.ArrayList;

public class algo1 {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(solution(num));
		
	}
	
    public static int solution(int n) {
        int answer 	= 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> sosuList = new ArrayList<Integer>();
        
        int sq = (int) Math.sqrt(n);
        int time = 0;
        
        //넘버의 제곱근까지 소수 구하기
        for(int k=2;k<=sq;k++) {
        	
        	for(int j=2;j<=k;j++) {
        		if(k%j==0 && k!=j) {
        			break;
        		} else if(k%j==0 && k==j) {
        			sosuList.add(k);
        			break;
        		}
        	}
        }
        
        for(int i=2; i<=n; i++) {
        	boolean chk = true;
        	for(Integer sosu: sosuList) {
        		time++;
        		if(i!=sosu && i%sosu==0) {
        			chk = false;
        		}
        	}

        	if(!chk) continue;
        	else {
        		answer++;
        	}
        }
        
        System.out.println(time);
        return answer;
    }
	
}
