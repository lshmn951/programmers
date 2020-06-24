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
		boolean [] visit = new boolean [26];// 무슨 문자의 타일이 존재하는지 체크하는 배열
		Tile [][] tiles = new Tile [26][2]; // board에 존재하는 각 타일의 위치를 저장하는 Tile 배열
		char [][] map = new char [m][n]; // board를 char형 배열로 변환

		int cnt=0;// 총 몇 종류의 타일이 존재하는지 저장
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
			boolean flag= false; // 불가능한지 아닌지 체크하는 변수 
			out :for(int j=0;j<26;j++) { // 알파벳 순서대로 타일을 제거
				if(visit[j]) {
					int maxX = Math.max(tiles[j][0].x, tiles[j][1].x);
					int minX = Math.min(tiles[j][0].x, tiles[j][1].x);
					int maxY = Math.max(tiles[j][0].y, tiles[j][1].y);
					int minY = Math.min(tiles[j][0].y, tiles[j][1].y);
					boolean dir = true;
					if((tiles[j][0].x<=tiles[j][1].x&&tiles[j][0].y<=tiles[j][1].y)||(tiles[j][1].x<=tiles[j][0].x&&tiles[j][1].y<=tiles[j][0].y)) {
						// 같은 종류의 타일이  왼쪽위 오른쪽아래에 존재할 경우
						dir = true;
					}else if((tiles[j][0].x>tiles[j][1].x&&tiles[j][0].y<=tiles[j][1].y)||(tiles[j][1].x>tiles[j][0].x&&tiles[j][1].y<=tiles[j][0].y)) {
						// 같은 종류의 타일이 왼쪽아래 오른쪽위에 존재할 경우
						dir = false;
					}
					char c = map[tiles[j][0].x][tiles[j][0].y];
					boolean check = false; // 타일을 이어주는 방법 2가지중 첫번째 방법이 가능한지 체크(가능하면 false)
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

					if(flag) { // 타일을 연결하는게 가능하다면 해당 타일들을 지우고 answer에 추가
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
