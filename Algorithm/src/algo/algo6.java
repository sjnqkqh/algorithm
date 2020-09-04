package algo;

import java.util.ArrayList;
import java.util.Collections;

public class algo6 {
	public static void main(String[] args) {

		String [] timetable = {"23:59"};
		//https://programmers.co.kr/learn/courses/30/lessons/17678#
		//GG 87점까진 나오는데 더 가기가 힘들다.
		//아 문제 너무 맵다... 아예 다른 방식으로 접근해야 완벽하게 풀이 가능할듯
		solution(1,1,1,timetable);
	}

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int min = t*(n-1);
        
        int lastMin  = -1, lastHour = -1;
        String lastTime = ""; 
        
        ArrayList<String> waiting = new ArrayList<String>();  
        for(String s : timetable) {
        	waiting.add(s);
        }
                
        lastHour = (min/60)+9;
        lastMin = min%60;
        
        //막차 시간
        if(lastHour<10) {
        	lastTime = "0"+lastHour;
        }else {
        	lastTime = ""+lastHour;
        }
        if(lastMin<10) {
        	lastTime = lastTime+":0"+lastMin;
        } else {
        	lastTime = lastTime+":"+lastMin;
        }
        // lastTime - 막차시간 무조건 여기까진 와야함
        // 막차 시간까지 최대 탑승 가능 인원
        int maxM = n*m;

        Collections.sort(waiting);
        String first = waiting.get(0);
        
        waiting.add(lastTime);
        
        Collections.sort(waiting);
        
        int pivot = -1;
        pivot = maxM<waiting.lastIndexOf(lastTime)? maxM : waiting.lastIndexOf(lastTime);
        System.out.println(waiting);
 
        if(pivot==0) pivot=1;
        waiting = new ArrayList<String>(waiting.subList(0, pivot));
        
        System.out.println(waiting);
        
        String last = waiting.get(waiting.size()-1);
        
        ArrayList<String> test = new ArrayList<String>();
        test.add(lastTime);
        test.add(last);
        Collections.sort(test);
        String desTime [] = last.split(":");
        int desH = Integer.parseInt(desTime[0]);
        int desM = Integer.parseInt(desTime[1]);
        
        desM = (desM==0)? 59:desM-1;
        desH = (desM==59)? desH-1:desH;
        
        answer = (desH<10)? "0"+desH : ""+desH; 
        answer = (desM<10)? answer+":0"+desM : answer+":"+desM;
        
        //마지막 탑승자가 탑승 가능한 막차 시간보다 빨리 도착했을 때 -> 막차 시간에 맞추면 됨
        if(test.indexOf(last)<test.indexOf(lastTime) && waiting.size()<maxM) {
        	answer = lastTime;
        }
        test.clear();
        test.add(lastTime);
        test.add(first);
        Collections.sort(test);
        //첫 탑승자가 막차시간보다 늦게 도착했을 때 -> 이 때도 그냥 막차 시간에 맞추면 됨
        
        if(test.indexOf(lastTime)<test.indexOf(first)) {
        	answer = lastTime;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
