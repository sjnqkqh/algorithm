package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(Arrays.toString(Solution.solution(n))); ;
	}
}

class Solution {
    public static int[] solution(int n) {
    	int max = (n*(n+1))/2;
        int answer [] = new int[max];
        
        int arr [][] = new int [n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		arr[i][j] = -1;
        	}
        }
        
        int i=0, j =0, k=1;
     
        arr[i][j] = k;
        while(k < max) {
        	while(i+1 < n && k < max && arr[i+1][j] < 0) {
        		arr[++i][j] = ++k;
        	}
        	while(j+1 < n && k < max && arr[i][j+1] < 0) {
        		arr[i][++j] = ++k;
        	}
        	while(i-1>0 && j-1>0 && k<max && arr[i-1][j-1]<0) {
        		arr[--i][--j] = ++k;
        	}
        }
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(i=0; i<n; i++) {
        	String num = "";
        	for(j=0;j<n;j++) {
        		if(arr[i][j] > 0) {
        			a.add(arr[i][j]);
        		}
        	}
        }
        
        for(i=0; i<a.size(); i++) {
        	answer[i] = a.get(i);
        }
        
        return answer;
    }
}
