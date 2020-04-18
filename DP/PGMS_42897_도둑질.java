package programmers;

import java.util.Arrays;

public class PGMS_42897_도둑질 {

	public static void main(String[] args) {
		int [] money = {1,2,3,1};
		int answer = solution(money);
		System.out.println(answer);

	}
	public static int solution(int[] money) {
        int answer = 0;
        int size = money.length;
        int [] dp = new int [size];
        dp[0] = money[0];
        dp[1] = money[0];
        for(int i=2;i<size-1;i++) {//첫번째 집 턴 경우
        	dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        }
        answer = dp[size-2];
        Arrays.fill(dp, 0);
        dp[size-1] = money[size-1];
        dp[size-2] = money[size-1];
        for(int i = size-3;i>0;i--) {//마지막 집 턴 경우
        	dp[i] = Math.max(dp[i+2]+money[i], dp[i+1]);
        }
        answer = Math.max(answer, dp[1]);
        return answer;
    }
}
