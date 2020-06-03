package programmers;

import java.util.PriorityQueue;

public class PGMS_42627_디스크컨트롤러 {
	public static void main(String[] args) {
		int [][] jobs = {{0,3},{5,9},{4,6}};
		System.out.println(solution(jobs));

		int [][] jobs2 = {{0,10},{4,10},{5,11},{15,2}};
		System.out.println(solution(jobs2));
	}
	public static int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<Job> pq = new PriorityQueue<>();
		for(int i=0;i<jobs.length;i++) { // 소요시간을 기준으로 오름차순 정렬하는 힙에 저장
			pq.add(new Job(jobs[i][0],jobs[i][1]));
		}
		int cur = 0;
		PriorityQueue<Job> copy = new PriorityQueue<>();

		while(!pq.isEmpty()||!copy.isEmpty()) {
			Job temp = null;
			boolean f=true;
			while(!pq.isEmpty()) {	        		
				if(f&&pq.peek().startTime<=cur) {// 현재 시간에서 시작할수 있는 작업중 소요시간이 가장 작은것
					temp = pq.poll();
					f = false;
					break;
				}
				else {
					copy.add(pq.poll());
				}
			}
			if(!f) {// 현재 시간에서 시작할 수 있는 작업이 있는 경우
				cur+=temp.time;
				answer+=(cur-temp.startTime);
				while(!copy.isEmpty()) {
					pq.add(copy.poll());
				}
			}else {// 현재 시간에서 시작할 수 있는 작업이 없는 경우
				while(!copy.isEmpty()) {
					if(temp==null) {
						temp = copy.poll();
					}else {
						if(temp.startTime>copy.peek().startTime) {//요청 시간이 가장 빠른것 추출
							pq.add(new Job(temp.startTime,temp.time));
							temp = copy.poll();
						}else {
							pq.add(copy.poll());
						}
					}
				}
				cur += (temp.startTime-cur+temp.time);
				answer +=(cur-temp.startTime);
			}
		}
		answer /= jobs.length;
		return answer;
	}
	public static class Job implements Comparable<Job>{
		int startTime;
		int time;
		public Job(int startTime, int time) {
			this.startTime = startTime;
			this.time = time;
		}
		@Override
		public int compareTo(Job o) {
			if(this.time<o.time) {
				return -1;
			}else if(this.time>o.time) {
				return 1;
			}else {
				return 0;
			}
		}

	}
}
