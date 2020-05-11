package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PGMS_1844_게임맵최단거리 {

	public static void main(String[] args) {
		int [][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps1));
		
		int [][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(maps2));
	}
	public static int solution(int[][] maps) {
        int answer = -1;
        int rsize = maps.length;
        int csize = maps[0].length;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Character> que = new LinkedList<>();
        que.add(new Character(0, 0, 1));
        maps[0][0] = 0;
        while(!que.isEmpty()) {
        	Character temp = que.poll();
        	int x = temp.x;
        	int y = temp.y;
        	int cnt = temp.cnt;
        	if(x==rsize-1 && y==csize-1) {
        		answer = cnt;
        		break;
        	}
        	for(int i=0;i<4;i++) {
        		int r = x+dirs[i][0];
        		int c = y+dirs[i][1];
        		if(r<0||c<0||r>=rsize||c>=csize) {
        			continue;
        		}
        		if(maps[r][c]==1) {
        			maps[r][c]=0;
        			que.add(new Character(r, c,cnt+1));
        		}
        	}
        }
        return answer;
    }
	public static class Character{
		int x,y;
		int cnt;
		public Character(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
