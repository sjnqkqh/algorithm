package algo;

import java.util.Arrays;

public class algo7 {
	public static void main(String[] args) {
		//https://programmers.co.kr/learn/courses/30/lessons/1829
		//��... ����� �Լ��� �� ������ ��¦ ���̵� ���ƴµ�...
		//dfs��� Ž������ ����ϴ� �� ����. flood fill�̶�� ������� Ǯ �� �ִٰ� �ϴµ�... �� �׷� �� �÷��̵� �ʸ� �ۿ� ����
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
