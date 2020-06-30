package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PGMS_12978_배달 {

	public static void main(String[] args) {
		int [][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		System.out.println(solution(5, road1, 3));
		
		int [][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		System.out.println(solution(6, road2, 4));

	}
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int [][] graph = new int [N+1][N+1];
        int [] visit = new int [N+1];// 1번 마을에서 해당 마을까지 가는데 걸리는 시간을 저장할 배열
        for(int i=0;i<road.length;i++) {
        	int a = road[i][0];
        	int b = road[i][1];
        	int c = road[i][2];
        	if(graph[a][b]>0) {// a,c를 연결하는 도로 중 가장 시간이 적게 걸리는 도로를 저장
        		graph[a][b] = graph[b][a] = Math.min(graph[a][b], c);
        	}else {
        		graph[a][b] = graph[b][a] = c;
        	}
        }
        for(int i=0;i<=N;i++) {
        	visit[i] = Integer.MAX_VALUE;
        }
        Queue<Town> que = new LinkedList<>();
        que.add(new Town(1,0));
        visit[1] = 0;
        while(!que.isEmpty()) {
        	Town temp = que.poll();
        	for(int i=1;i<=N;i++) {
        		if(graph[temp.cur][i]>0) {// 도로가 연결되어 있고
        			if(visit[i]>graph[temp.cur][i]+temp.time) {// 1번에서 i번 마을까지 가는데 걸리는 시간이 현재마을을 통해서 가는게 더 적게 걸린다면
        				visit[i] = graph[temp.cur][i]+temp.time;
        				que.add(new Town(i,temp.time+graph[temp.cur][i]));
        			}
        		}
        	}
        }
        for(int i=1;i<=N;i++) {
        	if(visit[i]<=K) {// 1번 마을에서 i번 마을까지 가는데 K보다 적은 시간이 걸리면 카운트
        		answer++;
        	}
        }
        return answer;
    }
	public static class Town{
		int cur;
		int time;
		public Town(int cur, int time) {
			this.cur = cur;
			this.time = time;
		}
		
	}
}
