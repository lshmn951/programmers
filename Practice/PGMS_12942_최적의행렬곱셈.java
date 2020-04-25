package programmers;

public class PGMS_12942_최적의행렬곱셈 {

	public static void main(String[] args) {
		int [][] m = {{5,3},{3,10},{10,6}};
		System.out.println(solution(m));

	}
	public static int solution(int[][] matrix_sizes) {
	    int answer = 0;
	    int size = matrix_sizes.length;
	    int dp[][] = new int [size][size];
	    for(int d=1;d<size;d++) {
	    	for(int i=0;i<size-d;i++) {
	    		int j=i+d;
	    		dp[i][j] = Integer.MAX_VALUE;
	    		for(int k=i;k<j;k++) {
	    			int val = dp[i][k]+dp[k+1][j]+matrix_sizes[i][0]*matrix_sizes[k][1]*matrix_sizes[j][1];
	    			dp[i][j] = Math.min(dp[i][j], val);
	    			
	    		}
	    	}
	    }
	    
	    answer = dp[0][size-1];
	    
	    return answer;
	}
}
