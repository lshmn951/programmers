package monthchallenge;

import java.util.*;
public class month09_1 {
	public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		set.add(numbers[i]+numbers[j]);
        	}
        }
        answer = new int [set.size()];
        int idx= 0;
        for(Integer n: set) {
        	answer[idx++] = n;
        }
        Arrays.sort(answer);
        return answer;
    }
}
