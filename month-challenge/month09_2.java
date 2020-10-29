package monthchallenge;

public class month09_2 {
	public int[] solution(int n) {
        int[] answer = {};
        int [][] dirs = {{1,0},{0,1},{-1,-1}};
        int [][] arr = new int [n][n];
        int r = -1;
        int c = 0;
        int num = 1;
        int d = 0;
        for(int i=n;i>0;i--) {
        	for(int j=0;j<i;j++) {
        		r +=dirs[d][0];
        		c +=dirs[d][1];
        		arr[r][c] = num++;
        	}
        	d = (d+1)%3;
        }
        answer = new int [n*(n+1)/2];
        int idx=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(arr[i][j]>0) {
        			answer[idx++] = arr[i][j];
        		}
        	}
        }
        return answer;
    }
}
