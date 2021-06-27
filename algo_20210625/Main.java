import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n, min, max;
	static int [][] countries, check;
	
	public static void main(String[] args) throws Exception {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		String [] str = br.readLine().split(" ");
//		
//		int n = Integer.parseInt(str[0]); 
//		int l = Integer.parseInt(str[1]);
//		int r = Integer.parseInt(str[2]);
//		
//		int [][] countries = new int [n][n]; 
//		
//		for(int i=0; i<n; i++) {
//			str = br.readLine().split(" ");
//			for(int j=0; j<n; j++) {
//				countries[i][j] = Integer.parseInt(str[(i*n)+j]);
//			}
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		String [] str = br.readLine().split(" ");
		
		int n = 2;
		int min = 20;
		int max = 50;
		
		int [][] countries = new int[n][n]; 
		boolean [][] check = new boolean[n][n];
		
		String [] str = {"50", "30", "20", "40"};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				countries[i][j] = Integer.parseInt(str[i*n+j]);
			}
		}
		
		check = moveCheck(countries, max, min);
		
	}	
	
	// 인구이동 체크 함수
	public static boolean[][] moveCheck(int[][] countries, int max, int min) {
		int [][] check = new int[countries.length][countries.length];
		
		
		// 어떤 연합을 만드는지 확인
		
		
		// 각 국가별로 인접한 세로줄에서 인구 이동이 일어나는지 확인 
		for(int i=0; i<countries.length; i++) {
			for(int j=0; j<countries.length-1; j++) {
				int diff = Math.abs(countries[i][j]-countries[i][j+1]);
				if(min <= diff && diff <= max) {
					check[i][j] = true;
					check[i][j+1] = true;
				}
			}
		}S
		
		// 각 국가별로 인접한 세로줄에서 인구 이동이 일어나는지 확인 
		for(int i=0; i<countries.length-1; i++) {
			for(int j=0; j<countries.length; j++) {
				int diff = Math.abs(countries[j][i]-countries[j+1][i]);
				if(min <= diff && diff <= max) {
					check[j][i] = true;
					check[j+1][i] = true;
				}
			}
		}
		
		return check;
	}
	
	// 원본 2차원 배열과 국경 개방 배열을 이용해서 국경 이동 함수
	public static int[][] move(int[][] countries, int[][] check){
		for(int i=0; i<countries.length; i++) {
			for (int j = 0; j < countries.length; j++) {
				
				
			}
		}
		
		
		
		return countries;
	}
	
	
}