package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PGMS_42629_라면공장 {

	public static void main(String[] args) {
		int stock = 4;
		int [] dates = {4,10,15};
		int [] supplies = {20,5,10};
		int k = 30;
		System.out.println(solution(stock, dates, supplies, k));
	}
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int idx = 0;
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2) {
					return -1;
				}else if(o1<o2) {
					return 1;
				}else {
					return 0;
				}
			}
		});
        while(stock<k) {
        	for(i=idx;i<dates.length && stock>=dates[i];i++) {
        		pq.add(supplies[i]);
        	}
        	idx=i;
        	stock+=pq.poll();
        	answer++;
        }
        return answer;
    }
}
