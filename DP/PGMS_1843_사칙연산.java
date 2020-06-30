package programmers;

import java.util.Arrays;

public class PGMS_1843_사칙연산 {

	public static void main(String[] args) {
		String [] arr1 = {"1", "-", "3", "+", "5", "-", "8"};
		System.out.println(solution(arr1));

		String [] arr2 = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
		System.out.println(solution(arr2));
	}
	public static int solution(String arr[]) {
        int answer = 1;
        int size = arr.length/2+1;
        int [][][] dp = new int [2][size][size];
        
        for(int i=0;i<size;i++) {
        	Arrays.fill(dp[0][i],-200000); // dp[0] 은 max 값
        	Arrays.fill(dp[1][i],200000); // dp[1] 은 min 값
        }
        
        for(int i=0;i<size;i++) {
        	dp[0][i][i] = dp[1][i][i] = Integer.parseInt(arr[i*2]); 
        }
        
        for(int oper=1;oper<size;oper++) {
        	for(int i=0;i<size-oper;i++) {
        		int j = oper + i;
        		for(int k=i;k<j;k++) {
        			if(arr[k*2+1].equals("+")) { // k와 k+1 사이의 연산자가 + 일때
        				dp[0][i][j] = Math.max(dp[0][i][j], dp[0][i][k]+dp[0][k+1][j]); //max는 i~k구간의 max값 + k+1~j구간의 max값
        				dp[1][i][j] = Math.min(dp[1][i][j], dp[1][i][k]+dp[1][k+1][j]); //min은 i~k구간의 min값 + k+1~j구간의 min값
        			}else { // k와 k+1 사이의 연산자가 - 일때
        				dp[0][i][j] = Math.max(dp[0][i][j], dp[0][i][k]-dp[1][k+1][j]); //max는 i~k구간의 max값 - k+1~j구간의 min값
        				dp[1][i][j] = Math.min(dp[1][i][j], dp[1][i][k]-dp[0][k+1][j]); //min은 i~k구간의 min값 - k+1~j구간의 max값
        			}
        		}
        	}
        }
        answer = dp[0][0][size-1];
        return answer;
    }
}
