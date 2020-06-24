package programmers;

import java.util.Arrays;

public class PGMS_1836_리틀프렌즈사천성 {

	public static void main(String[] args) {
		String [] board1 = {"DBA", "C*A", "CDB"};
		System.out.println(solution(3, 3, board1));

		String [] board2 = {"NRYN", "ARYA"};
		System.out.println(solution(2, 4, board2));

		String [] board3 = {".ZI.", "M.**", "MZU.", ".IU."};
		System.out.println(solution(4, 4, board3));

		String [] board4 = {"BA", "AB"};
		System.out.println(solution(2, 2, board4));

	}
	public static String solution(int m, int n, String[] board) {
		String answer = "";
		boolean [] visit = new boolean [26];
		Tile [][] tiles = new Tile [26][2]; 
		char [][] map = new char [m][n];

		int cnt=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				char a = board[i].charAt(j);
				map[i][j] = a;
				if(a>='A'&&a<='Z') {
					if(!visit[a-'A']) {
						cnt++;
						visit[a-'A'] = true;
						tiles[a-'A'][0] = new Tile(i,j);
					}else {
						tiles[a-'A'][1] = new Tile(i,j);
					}
				}
			}
		}
		for(int t=0;t<cnt;t++) {
			boolean flag= false;
			out :for(int j=0;j<26;j++) {
				if(visit[j]) {
					int maxX = Math.max(tiles[j][0].x, tiles[j][1].x);
					int minX = Math.min(tiles[j][0].x, tiles[j][1].x);
					int maxY = Math.max(tiles[j][0].y, tiles[j][1].y);
					int minY = Math.min(tiles[j][0].y, tiles[j][1].y);
					boolean dir = true;
					if((tiles[j][0].x<=tiles[j][1].x&&tiles[j][0].y<=tiles[j][1].y)||(tiles[j][1].x<=tiles[j][0].x&&tiles[j][1].y<=tiles[j][0].y)) {
						dir = true;
					}else if((tiles[j][0].x>tiles[j][1].x&&tiles[j][0].y<=tiles[j][1].y)||(tiles[j][1].x>tiles[j][0].x&&tiles[j][1].y<=tiles[j][0].y)) {
						dir = false;
					}
					char c = map[tiles[j][0].x][tiles[j][0].y];
					boolean check = false;
					for(int i=minX;i<=maxX;i++) {
						if(map[i][minY]!='.'&&map[i][minY]!=c) {
							check = true;
							break;
						}
					}
					if(!check) {
						if(!dir) {
							for(int i=minY;i<=maxY;i++) {
								if(map[minX][i]!='.'&&map[minX][i]!=c) {
									check = true;
									break;
								}
							}
						}else {
							for(int i=minY;i<=maxY;i++) {
								if(map[maxX][i]!='.'&&map[maxX][i]!=c) {
									check = true;
									break;
								}
							}
						}
					}
					if(check) {
						for(int i=minX;i<=maxX;i++) {
							if(map[i][maxY]!='.'&&map[i][maxY]!=c) {
								continue out;
							}
						}
						if(!dir) {
							for(int i=minY;i<=maxY;i++) {
								if(map[maxX][i]!='.'&&map[maxX][i]!=c) {
									continue out;
								}
							}
						}else {
							for(int i=minY;i<=maxY;i++) {
								if(map[minX][i]!='.'&&map[minX][i]!=c) {
									continue out;
								}
							}
						}
					}
					flag = true;

					if(flag) {
						visit[j]=false;
						char tmp = (char) ('A'+j);
						map[tiles[j][0].x][tiles[j][0].y] = '.';
						map[tiles[j][1].x][tiles[j][1].y] = '.';
						answer+= tmp;
						break;
					}
				}
			}
			if(!flag) {
				answer = "IMPOSSIBLE";
				break;
			}
		}
		return answer;
	}
	public static class Tile{
		int x,y;
		public Tile(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
