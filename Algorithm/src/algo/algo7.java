package algo;

import java.util.Arrays;

public class algo7 {
	public static void main(String[] args) {
		//https://programmers.co.kr/learn/courses/30/lessons/1829
		//어... 재귀적 함수인 것 같은데 살짝 난이도 미쳤는데...
		//dfs라는 탐색법을 사용하는 것 같다. flood fill이라는 방식으로 풀 수 있다고 하는데... 난 그런 거 플루이드 필름 밖에 몰라
		int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		solution(6,4,picture);
	}

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int [] pic: picture) {
        	System.out.println(Arrays.toString(pic));
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
