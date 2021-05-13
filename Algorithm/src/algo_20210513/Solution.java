package algo_20210513;


import java.io.FileInputStream;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("./res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		int count = 1; //반복횟수 11시 55분 시작
		while(sc.hasNext())
		{	
			int roopCount  = Integer.parseInt(sc.nextLine());		
			int [] heigths = parse(sc.nextLine());				
			
			// 1. 최저/최고 인덱스 찾기
			// 2. 최저 인덱스 + 1/ 최고 인덱스 +1
			// 3. roopCount만큼 반복 
			// 4. 최종적으로 최고/최저치 탐색 후 차이 산출
			
			for(int i=0; i<roopCount; i++) {
				int min = Integer.MAX_VALUE;		// 최저값
				int minIndex = Integer.MAX_VALUE;	// 최저값 인덱스
				int max = -1;						// 최고값 
				int maxIndex = -1;					// 최고값 인덱스
				
				
				// 1. 최저/최고 인덱스 찾기
				for(int j=0; j<heigths.length; j++) {
					if(min > heigths[j]) {
						min = heigths[j];
						minIndex = j;
					}
					if(max < heigths[j]) {
						max = heigths[j];
						maxIndex = j;
					}
				}
				
				// 2.최저 인덱스 + 1/ 최고 인덱스 +1
				heigths[minIndex] = heigths[minIndex]+1;
				heigths[maxIndex] = heigths[maxIndex]-1;
			}
			
			// 최저/최고 인덱스 찾기
			int low = Integer.MAX_VALUE;
			int top = -1;
			
			for(int j=0; j<heigths.length; j++) {
				low = (low > heigths[j]) ? heigths[j] : low; 
				top = (top < heigths[j]) ? heigths[j] : top; 
			}
			
			System.out.println("#"+count+" "+(top-low));

			count++;
		}
	}
	
	// 입출력 값 파싱 함수
	public static int [] parse(String str) {
		String [] tempArr = str.split(" ");
		int [] result = new int[tempArr.length];
		
		for(int i=0; i<tempArr.length; i++) {
			result[i] = Integer.parseInt(tempArr[i]);
		}
		
		return result; 
	}
}