package kakao2020_internship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGMS_67259_경주로건설 {

	public static void main(String[] args) {
		int [][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(board1));

		int [][] board2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0},{ 0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
		System.out.println(solution(board2));
		
		int [][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.println(solution(board3));
		
		int [][] board4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(board4));
	}
	static int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; 
	public static int solution(int[][] board) {
		int n = board.length;
		int [][] visit = new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Car> car = new LinkedList<>();
		car.add(new Car(0, 0, 0, 0, 0));
		car.add(new Car(0, 0, 0, 0, 1));
		visit[0][0] = 0;
		while(!car.isEmpty()) {
			Car temp = car.poll();
			for(int i=0;i<4;i++) {
				int r = temp.x+dirs[i][0];
				int c = temp.y+dirs[i][1];
				if(r<0||c<0||r>=n||c>=n) {
					continue;
				}
				if(board[r][c]==1) {
					continue;
				}
				if(temp.dir==0) {
					if(i==0||i==1) {
						if(temp.corner*500+(temp.direct+1)*100<=visit[r][c]) {
							visit[r][c] = temp.corner*500+(temp.direct+1)*100;
							car.add(new Car(r, c, temp.corner, temp.direct+1, 0));
						}
					}else {
						if((temp.corner+1)*500+(temp.direct+1)*100<=visit[r][c]) {
							visit[r][c] = (temp.corner+1)*500+(temp.direct+1)*100;
							car.add(new Car(r, c, temp.corner+1, temp.direct+1, 1));
						}
					}
				}else if(temp.dir==1) {
					if(i==0||i==1) {
						if((temp.corner+1)*500+(temp.direct+1)*100<=visit[r][c]) {
							visit[r][c] = (temp.corner+1)*500+(temp.direct+1)*100;
							car.add(new Car(r, c, temp.corner+1, temp.direct+1, 0));
						}
					}else {
						if(temp.corner*500+(temp.direct+1)*100<=visit[r][c]) {
							visit[r][c] = temp.corner*500+(temp.direct+1)*100;
							car.add(new Car(r, c, temp.corner, temp.direct+1, 1));
						}
					}
				}
			}
		}
		return visit[n-1][n-1];
	}
	public static class Car{
		int x,y;
		int corner;
		int direct;
		int dir;
		public Car(int x, int y, int corner, int direct, int dir) {
			this.x = x;
			this.y = y;
			this.corner = corner;
			this.direct = direct;
			this.dir = dir;
		}

	}
}
