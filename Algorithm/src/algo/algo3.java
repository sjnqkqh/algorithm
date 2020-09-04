package algo;

import java.util.Arrays;
import java.util.regex.Pattern;

public class algo3 {
	public static void main(String[] args) {
		//https://programmers.co.kr/learn/courses/30/lessons/17682
		String dartResult = "1D2S#10S";

		solution(dartResult);
	}

	public static int solution(String dartResult) {
		String[] dr = dartResult.split("");
		
		for(int s=0; s<dr.length; s++) {
			if(dr[s].equals("1")&&dr[s+1].equals("0")) {
				dr[s] 	= "10";
				dr[s+1] = "-";
			}
		}
		
		int currencyScore = 0, totalScore = 0, time = 0;
		int[] scoreBoard = new int[3];

		for (int i = 0; i < dr.length; i++) {

			if (dr[i].equals("#")) {
				currencyScore = currencyScore * -1;
			} else if (dr[i].equals("*")) {
				if (time >= 1) {
					scoreBoard[time - 1] = scoreBoard[time - 1] * 2;
					currencyScore = currencyScore * 2;
				} else {
					currencyScore = currencyScore * 2;
				}

			} else if (dr[i].equals("S")) {

			} else if (dr[i].equals("D")) {
				currencyScore = currencyScore * currencyScore;
			} else if (dr[i].equals("T")) {
				currencyScore = currencyScore * currencyScore * currencyScore;
			} else if (dr[i].equals("-")) {
				continue;
			} else {
				currencyScore = Integer.parseInt(dr[i]);
			}
			

			if (i + 1 == dr.length || Pattern.matches("^[0-9]*$", dr[i + 1])) {
				time++;

				scoreBoard[time - 1] = currencyScore;
				currencyScore = 0;
			}

		}
		for (int f = 0; f < scoreBoard.length; f++) {
			totalScore = totalScore + scoreBoard[f];
		}


		return totalScore;
	}
}
