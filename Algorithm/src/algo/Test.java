package algo;

public class Test {
	public static void main(String[] args) {
		int [] a = {1,2,3,4};
		int [] b = {-3,-1,0,2};
		
		System.out.println(Solution.solution(a,b));
		
	}
}

class Solution {
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
        	answer = answer + a[i]*b[i];
        }
        
        return answer;
    }
}
