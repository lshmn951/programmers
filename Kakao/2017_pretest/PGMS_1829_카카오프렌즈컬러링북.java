package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PGMS_1829_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int [][] picture1 = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int [] answer = solution(6, 4, picture1);
		System.out.println(answer[0]+" "+answer[1]);

		int [][] picture2 = {{1,1,1,0},{1,1,1,0},{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
		int [] answer2 = solution(6, 4, picture2);
		System.out.println(answer2[0]+" "+answer2[1]);
	}
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Point> que = new LinkedList<>();
        int [][] copy = new int [m][n];
        for(int i=0;i<m;i++) {// 복사한 배열을 사용해야만 정답 처리....뭐지..
        	copy[i] = picture[i].clone();
        }
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(copy[i][j]!=0) {
        			int temp = copy[i][j];
        			int cnt = 1;
        			copy[i][j]=0;
        			numberOfArea++;
        			que.add(new Point(i,j));
        			while(!que.isEmpty()) {
        				Point cur = que.poll();
        				for(int d=0;d<4;d++) {
        					int r = cur.x+dirs[d][0];
        					int c = cur.y+dirs[d][1];
        					if(r<0||c<0||r>=m||c>=n) {
        						continue;
        					}
        					if(copy[r][c]==temp) {
        						copy[r][c] = 0;
        						cnt++;
        						que.add(new Point(r,c));
        					}
        				}
        			}
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
	public static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
