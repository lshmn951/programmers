package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGMS_43162_네트워크 {

	public static void main(String[] args) {
		int [][] computers1 = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
		int [][] computers2 = new int[][] {{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(3,computers1));
		System.out.println(solution(3,computers2));
	}
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [][] arr = new boolean[n][n];
        boolean [] visit = new boolean [n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(i!=j) {
        			if(computers[i][j]==1) {
        				arr[i][j] = true;
        			}
        		}
        	}
        }
        Queue<Integer> que= new LinkedList<Integer>();
        for(int i=0;i<n;i++) {
        	if(!visit[i]) {
        		answer++;
        		visit[i]=true;
        		que.add(i);

        		while(!que.isEmpty()) {
        			int temp = que.poll();
        			for(int j=0;j<n;j++) {
        				if(arr[temp][j] && !visit[j]) {
        					visit[j]=true;
        					que.add(j);
        				}
        			}
        		}
        	}
        }
        return answer;
    }
}
