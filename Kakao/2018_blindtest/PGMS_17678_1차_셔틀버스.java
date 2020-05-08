package programmers;

import java.util.PriorityQueue;

public class PGMS_17678_1차_셔틀버스 {

	public static void main(String[] args) {
		String []tt= {"09:10", "09:09", "08:00"};
		System.out.println(solution(2, 10, 2, tt));
	}
	public static String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<timetable.length;i++) {
			int hour = Integer.parseInt(timetable[i].substring(0,2));
			int minute = Integer.parseInt(timetable[i].substring(3, 5));
			int time = hour*60 + minute;
			pq.add(time);
		}

		int end = 9*60;
		for(int i=0;i<n;i++) {
			int cnt=0;
			int start = 9*60+i*t;
			while(!pq.isEmpty()&&cnt<m) {
				if(pq.peek()<=start) {
					end = pq.poll();
					cnt++;
				}else {
					break;
				}
			}
			if(i==n-1) {
				if(cnt==m) {
					end -= 1; 
				}else {
					end = start;
				}
			}
		}
		int hour = end/60;
		if(hour<10) {
			answer+="0"+Integer.toString(hour);
		}else {
			answer+=Integer.toString(hour);
		}
		answer += ":";
		int minute = end%60;
		if(minute<10) {
			answer+="0"+Integer.toString(minute);
		}else {
			answer+=Integer.toString(minute);
		}
		return answer;
	}
}
