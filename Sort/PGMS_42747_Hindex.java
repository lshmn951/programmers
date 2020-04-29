package programmers;

import java.util.Arrays;

public class PGMS_42747_Hindex {

	public static void main(String[] args) {
		int [] c = {3,1,0,5,6};
		System.out.println(solution(c));

	}
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i=0;i<len-1;i++) {
        	if(i==0) {
        		for(int j=0;j<=citations[i];j++) {
        			if(len>=j) {
        				answer = j;
        			}
        		}
        	}
        	for(int j=citations[i]+1;j<=citations[i+1];j++) {
        		if(len-(i+1)>=j) {
        			answer = j;
        		}
        	}
        }
        return answer;
    }
}
