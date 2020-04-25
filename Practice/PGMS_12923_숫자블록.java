package programmers;

import java.util.Arrays;

public class PGMS_12923_숫자블록 {

	public static void main(String[] args) {
		int[] answer = solution(999999999,1000000000);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(long begin, long end) {
		int size = (int)(end-begin+1);
		int[] answer = new int [size];
		int idx = 0;
		if(begin==1) {
			answer[0]=0;
			begin++;
			idx++;
		}
		out:for(long i=begin;i<=end;i++) {
			for(long j=2;j<=(long)Math.sqrt(i);j++) {
				if(i%j==0 && i/j<=10000000) {
					answer[idx++]= (int)(i/j);
					continue out;
				}
			}
			answer[idx++]=1;
		}
		return answer;
	}
}
