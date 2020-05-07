package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PGMS_42889_실패율 {

	public static void main(String[] args) {
		int [] stages1 = {2,1,2,6,2,4,3,3};
		int [] answer1 = solution(5, stages1);
		System.out.println(Arrays.toString(answer1));
		

		int [] stages2 = {4,4,4,4,4};
		int [] answer2 = solution(4, stages2);
		System.out.println(Arrays.toString(answer2));
	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int [N];
        int [] cur = new int [N+1];
        for(int i=0;i<stages.length;i++) {
        	if(stages[i]!=N+1) {
        		cur[stages[i]]++;
        	}
        }
        int user = stages.length;
        int sum = 0;
        PriorityQueue<Fail> pq = new PriorityQueue<>();
        for(int i=1;i<N+1;i++) {
        	Fail temp = null;
        	if(user-sum!=0) {
        		temp = new Fail(i,((double)cur[i]/(user-sum)));
        	}else {
        		temp = new Fail(i,0);
        	}
        	pq.add(temp);
        	sum+=cur[i];
        }
        int idx = 0;
        while(!pq.isEmpty()) {
        	answer[idx++] = pq.poll().stage;
        }
        return answer;
    }
	public static class Fail implements Comparable<Fail>{
		int stage;
		double fail;
		public Fail(int stage, double fail) {
			this.stage = stage;
			this.fail = fail;
		}
		@Override
		public int compareTo(Fail o) {
			if(this.fail>o.fail) {
				return -1;
			}else if(this.fail<o.fail) {
				return 1;
			}else {
				if(this.stage<o.stage) {
					return -1;
				}else if(this.stage>o.stage) {
					return 1;
				}else {
					return 0;
				}
			}
		}
	}
}
