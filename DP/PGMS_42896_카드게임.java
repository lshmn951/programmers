package programmers;

public class PGMS_42896_카드게임 {

	public static void main(String[] args) {
		int [] left = {3,2,5};
		int [] right= {2,4,1};
		System.out.println(solution(left,right));

	}
	public static int solution(int[] left, int[] right) {
        int answer = 0;
        int dp[][] = new int [left.length+1][right.length+1];
        for(int i=left.length-1;i>=0;i--) {
        	for(int j=right.length-1;j>=0;j--) {
        		if(left[i]>right[j]) {
        			dp[i][j] = dp[i][j+1]+right[j];
        		}else {
        			dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]);
        		}
        	}
        }
        answer = dp[0][0];
        return answer;
    }
}
