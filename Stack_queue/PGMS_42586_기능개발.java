package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGMS_42586_기능개발 {

	public static void main(String[] args) {
		int [] progresses = {99,99,99,99,99};
		int [] speeds = {3,3,3,3,3};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> que = new LinkedList<>();
        int day = 0;
        for(int i=0;i<progresses.length;i++) {
        	day += (100-progresses[i]+speeds[i]-1-(speeds[i]*day))/speeds[i];
        	int count = 0;
        	for(int j=i;j<progresses.length;j++) {
        		if(progresses[j]+speeds[j]*day>=100) {
        			count++;
        			i=j;
        		}else {
        			break;
        		}
        	}
        	que.add(count);
        	System.out.println(day);
        }
        answer = new int [que.size()];
        int idx = 0;
        while(!que.isEmpty()) {
        	answer[idx++] = que.poll();
        }
        return answer;
    }
}
