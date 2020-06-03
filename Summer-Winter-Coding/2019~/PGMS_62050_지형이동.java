package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGMS_62050_지형이동 {

	public static void main(String[] args) {
		int [][] land1 = {{1,4,8,10},{5,5,5,5},{10,10,10,10},{10,10,10,20}};
		System.out.println(solution(land1, 3));
		
		int [][] land2 = {{10,11,10,11},{2,21,20,10},{1,20,21,11},{2,1,2,1}};
		System.out.println(solution(land2, 1));

	}
	public static int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        boolean [][] visit = new boolean [n][n];
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<Move> pq = new PriorityQueue<>();//사다리를 통해 이동한 지점의 시작점(사다리 높이를 기준으로 오름차순 정렬)
        Queue<Move> que = new LinkedList<>();//사다리 없이 이동할 지점들
        pq.add(new Move(0,0,0));
        while(!pq.isEmpty()) {
        	Move start = pq.poll();// 사다리 높이가 가장 최소인 것 부터 꺼낸다
        	if(visit[start.x][start.y]) {// 이미 방문한 곳이면 넘어감
        		continue;
        	}
        	answer += start.len; // 사다리의 높이를 정답에 더한다
        	que.add(start); // 사다리 없이 이동할 시작점을 큐에 추가
        	visit[start.x][start.y] = true;
        	while(!que.isEmpty()) {
        		Move temp = que.poll();
        		for(int i=0;i<4;i++) {
        			int r = temp.x+dirs[i][0];
        			int c = temp.y+dirs[i][1];
        			if(r<0||c<0||c>=n||r>=n) { // 범위를 벗어난 경우
        				continue;
        			}
        			if(visit[r][c]) { // 이미 방문한 곳
        				continue;
        			}
        			if(Math.abs(land[temp.x][temp.y]-land[r][c])<=height) { // 사다리 없이 이동 가능한 경우
        				visit[r][c] = true;
        				que.add(new Move(r,c,0));
        			}else { // 사다리를 통해 이동해야 하는 경우
        				pq.add(new Move(r,c,Math.abs(land[temp.x][temp.y]-land[r][c])));
        			}
        		}
        	}
        }
        return answer;
    }
	public static class Move implements Comparable<Move>{
		int x,y;
		int len;
		public Move(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
		@Override
		public int compareTo(Move o) {
			if(this.len<o.len) {
				return -1;
			}else if(this.len>o.len) {
				return 1;
			}else {
				return 0;
			}
		}
		
	}
}
