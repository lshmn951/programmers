package programmers;

import java.util.PriorityQueue;

public class PGMS_42626_더맵게 {

	public static void main(String[] args) {
		int [] scoville = {1,2,3,9,10,12};
		System.out.println(solution(scoville, 7));
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        while(pq.size()>=2) {
        	if(pq.peek()>=K) {
        		break;
        	}
        	int first = pq.poll();
        	int second = pq.poll();
        	answer++;
        	pq.add(first+(second*2));
        }
        if(pq.size()==1&&pq.peek()<K) {
        	return -1;
        }
        return answer;
    }
}
