package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PGMS_42981_무지의먹방라이브 {

	public static void main(String[] args) {
		int [] food_times = {5,5,5};
		System.out.println(solution(food_times, 15));

	}
	public static int solution(int[] food_times, long k) {

        Deque<Food> dq = new ArrayDeque<>();
        long total = 0;
        for(int i=0;i<food_times.length;i++) {
        	dq.add(new Food(food_times[i],i+1));
        	total += food_times[i];
        }
        if(total<=k) {
        	return -1;
        }
        while(!dq.isEmpty()) {
        	if(k<dq.size()) {
        		while(k-->0) {
        			dq.pop();
        		}
        		return dq.pop().idx;
        	}else if(k==dq.size()) {
        		return dq.pop().idx;
        	}else {
        		long div = k/dq.size();
        		long mod = k%dq.size();
        		long sum = 0;
        		int size = dq.size();
        		while(size-->0) {
        			Food temp = dq.pop();
        			if(temp.time-div<=0) {
        				sum+= Math.abs(temp.time-div);
        			}else {
        				temp.time-=div;
        				dq.add(new Food(temp.time,temp.idx));
        			}
        		}
        		k = (mod+sum);
        	}
        }
        return -1;
    }
	public static class Food{
		int time;
		int idx;
		public Food(int time, int idx) {
			this.time = time;
			this.idx = idx;
		}
		
	}
}
