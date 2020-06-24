package programmers;

public class PGMS_12907_거스름돈 {

	public static void main(String[] args) {
		int [] money = {1,2,5};
		System.out.println(solution(5, money));

	}
	final static int mod = 1000000007;
	public static int solution(int n, int[] money) {
        int answer = 0;
        int [] dp = new int [n+1];// dp[n]은 n원을 거슬러 줄 수 있는 방법의 수
        dp[0] = 1;
        for(int i=money[0];i<=n;i+=money[0]) {
        	dp[i] = 1;
        }
        for(int i=1;i<money.length;i++) {
        	for(int j=0;j<=n;j++) {
        		if(dp[j]>0 && j+money[i]<=n) {
        			dp[j+money[i]] += dp[j]%mod;
        		}
        	}
        }
        answer = dp[n];
        return answer;
    }
}
