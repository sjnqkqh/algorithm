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
    
    // 2���� �迭�� �̷��ϸ� �ش� �迭 ���� ��� ���� �������� Ȯ��
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
    
    // 2���� �迭�� �Է��ϸ� �ش� �迭�� 4����ϴ� �Լ�
    public static void quard(int x, int y, int n) {
    	
    	// �Է��� �迭�� ��� ���� ���� �̷���� �ִٸ� �ش� �� ī��Ʈ ����
    	if(check(x,y,n)) {
    		int val = map[x][y];
    		if(val==1) one++;
    		else zero++;
    		return;
    	}
    	
    	// �Է��� �迭�� ��� ���� ���� �ƴ϶�� 4���� ������ �ٽ� ���
    	int half = n/2;
    	quard(x, y, half);
    	quard(x+half, y, half);
    	quard(x, y+half, half);
    	quard(x+half, y+half, half);
   
    }
    
    
}
