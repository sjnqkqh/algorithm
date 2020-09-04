package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class algo4 {
	public static void main(String[] args) {
		//https://programmers.co.kr/learn/courses/30/lessons/17677

		solution("aa1+aa2", "AAAA12");
	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		int sLeng = 0, lLeng = 0;
		int gyo = 0, hap = 0;
		ArrayList<String> gyoArr = new ArrayList<String>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		ArrayList<String> strArr1 = new ArrayList<String>();
		ArrayList<String> strArr2 = new ArrayList<String>();

		String[] tempArr = str1.split("");

		//���ڿ� ����Ʈ�� ���� (�����ڸ�)
		for (int i = 0; i < tempArr.length - 1; i++) {
			if (Pattern.matches("^[a-zA-Z]*$", tempArr[i]) && Pattern.matches("^[a-zA-Z]*$", tempArr[i + 1]))
				strArr1.add(tempArr[i] + tempArr[i + 1]);
		}

		tempArr = str2.split("");
		for (int i = 0; i < tempArr.length - 1; i++) {
			if (Pattern.matches("^[a-zA-Z]*$", tempArr[i]) && Pattern.matches("^[a-zA-Z]*$", tempArr[i + 1]))
				strArr2.add(tempArr[i] + tempArr[i + 1]);
		}

		// ���� (���� ����ȭ)
		Collections.sort(strArr1);
		Collections.sort(strArr2);

		sLeng = strArr1.size();
		lLeng = strArr2.size();
		
		// ������ ���� ���ϱ�
		for (String st1 : strArr1) {
			if (strArr2.contains(st1)) {
				gyo++;
				strArr2.remove(st1);
				gyoArr.add(st1);
				continue;
			}
		}
		
		// ������ ���� ���ϱ�
		hap = sLeng + lLeng - gyo;

		if (hap == 0) {
			answer = 65536;
		} else {
			answer = Math.round(gyo * 65536 / hap);
		}

		return answer;
	}
}
