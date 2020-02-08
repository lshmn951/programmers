package programmers;

import java.util.Arrays;

public class ±¸¸íº¸Æ® {
	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int low = 0 ;
	        int high = people.length-1;
	        while(low<=high) {
	        	if(people[low]+people[high]<=limit) {
	        		low++;
	        	}
	        	high--;
	        	answer++;
	        }
	        return answer;
	    }
	}
}
