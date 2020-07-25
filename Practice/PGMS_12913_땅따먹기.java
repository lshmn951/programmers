package programmers;

public class PGMS_12913_땅따먹기 {
	public static void main(String[] args) {
		int [][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
	}
	static int solution(int[][] land) {
        int answer = 0;
        int [][] dp = new int [land.length][4];
        for(int i=0;i<4;i++) {
        	dp[0][i] = land[0][i];
        }
        for(int i=1;i<land.length;i++) {
        	for(int k=0;k<4;k++) {
        		int max = 0;
        		for(int j=0;j<4;j++) {
            		if(k!=j) {
            			max = Math.max(max, dp[i-1][j]);
            		}
            	}
        		dp[i][k] = max+land[i][k];
        	}
        }
        for(int i=0;i<4;i++) {
        	answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        return answer;
    }
	
}
