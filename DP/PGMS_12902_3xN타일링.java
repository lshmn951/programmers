package programmers;

public class PGMS_12902_3xN타일링 {
	final static int mod = 1000000007;
	public static void main(String[] args) {
		System.out.println(solution(4));
	}
	public static int solution(int n) {
        long [] dp = new long[n+1];
        long add = 0;
        dp[0] = 1;
        dp[2] = 3;
        if(n%2==1) {
        	return 0;
        }
        for(int i=4;i<=n;i+=2) {
        	add+=dp[i-4]*2;
        	dp[i] = dp[i-2]*3 +add;
        	dp[i] %=mod;
        	add %=mod;
        }
        return (int)dp[n];
    }
}
