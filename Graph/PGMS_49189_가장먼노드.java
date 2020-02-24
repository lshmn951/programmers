package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PGMS_49189_가장먼노드 {

	public static void main(String[] args) {
		int [][] edge = new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(6,edge));
	}
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		boolean [][] arr = new boolean[n+1][n+1];
		boolean [] visit = new boolean [n+1];
		int max= 0;
		for(int i=0;i<edge.length;i++) {
			arr[edge[i][0]][edge[i][1]]= true;
			arr[edge[i][1]][edge[i][0]]= true;
		}
		Queue<Node>que = new LinkedList<>();
		que.add(new Node(1,0));
		visit[1] = true;
		while(!que.isEmpty()) {
			Node temp = que.poll();
			if(temp.y>max) {
				max = temp.y;
				answer=1;
			}
			else if(temp.y==max) {
				answer++;
			}
			
			for(int i=1;i<=n;i++) {
				if(arr[temp.x][i] && !visit[i]) {
					visit[i] = true;
					que.add(new Node(i,temp.y+1));
				}
			}
		}
		return answer;
	}
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
}
