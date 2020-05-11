package programmers;

import java.util.Arrays;

public class PGMS_12987_숫자게임 {

	public static void main(String[] args) {
		int [] A = {5,1,3,7};
		int [] B = {2,2,6,8};
		System.out.println(solution(A,B));
		A = new int [] {2,2,2,2};
		B = new int [] {1,1,1,1};
		System.out.println(solution(A,B));
	}
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idxb = 0;
        int idxa = 0;
        while(idxb<B.length) {
        	if(A[idxa]<B[idxb]) {
        		idxa++;
        		idxb++;
        		answer++;
        	}else {
        		idxb++;
        	}
        }
        return answer;
    }
}
