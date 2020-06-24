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
        	// 각 기능별 완료 날짜를 day에 저장
        	day += (100-progresses[i]+speeds[i]-1-(speeds[i]*day))/speeds[i];
        	int count = 0;
        	for(int j=i;j<progresses.length;j++) {
        		//현재 날짜에서 완료 가능한 작업들 수를 센다
        		if(progresses[j]+speeds[j]*day>=100) {
        			count++;
        			i=j;
        		}else {
        			// 현재 날짜에서 완료가 불가능하다면 멈추고 다음 완료 날짜로 넘어감
        			break;
        		}
        	}
        	que.add(count);// 각 날짜별 완료 작업 수를 저장
        }
        answer = new int [que.size()];
        int idx = 0;
        while(!que.isEmpty()) {
        	answer[idx++] = que.poll();
        }
        return answer;
    }
}
