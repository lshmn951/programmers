package programmers;

import java.util.Arrays;

public class PGMS_12938_최고의집합 {

	public static void main(String[] args) {
		int [] answer1 = solution(2, 9);
		int [] answer2 = solution(2, 1);
		int [] answer3 = solution(2, 8);
		
		System.out.println(Arrays.toString(answer1));
		System.out.println(Arrays.toString(answer2));
		System.out.println(Arrays.toString(answer3));

	}
	public static int[] solution(int n, int s) {
        int[] answer = {};
        answer = new int [1];
        if(n==1) {
        	answer[0] = s;
        }else if(n>s) {
        	answer[0] = -1;
        }else {
        	int div = s/n;
        	int mod = s%n;
        	answer = new int [n];
        	for(int i=0;i<n;i++) {
        		answer[i] = div;
        	}
        	for(int i=n-1;i>n-1-mod;i--) {
        		answer[i]++;
        	}
        }
        
        return answer;
    }
}
