package algo;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int [][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		
		System.out.println(Arrays.toString(Solution.solution(arr)));;
	}
}

class Solution {
	static int[][] map;
	static int one = 0;
	static int zero = 0;

	public static int[] solution(int [][] arr) {
        int[] answer = new int[2];
        
        int n = arr.length;
        map = arr;
        
        quard(0,0,n);
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
    
    // 2차원 배열을 이력하면 해당 배열 안의 모든 수가 동일한지 확인
    public static boolean check(int x, int y, int k) {
    	int first = map[x][y];
    	
    	for(int i=x; i<x+k; i++) {
    		for(int j=y; j<y+k; j++) {
    			if(map[i][j] != first) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    // 2차원 배열을 입력하면 해당 배열을 4등분하는 함수
    public static void quard(int x, int y, int n) {
    	
    	// 입력한 배열이 모두 같은 수로 이루어져 있다면 해당 수 카운트 증가
    	if(check(x,y,n)) {
    		int val = map[x][y];
    		if(val==1) one++;
    		else zero++;
    		return;
    	}
    	
    	// 입력한 배열이 모두 같은 수가 아니라면 4개로 나눠서 다시 재귀
    	int half = n/2;
    	quard(x, y, half);
    	quard(x+half, y, half);
    	quard(x, y+half, half);
    	quard(x+half, y+half, half);
   
    }
    
    
}
