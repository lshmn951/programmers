package programmers;

import java.util.Arrays;

public class PGMS_17679_1차_프렌즈4블록 {

	public static void main(String[] args) {
		String [] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(4, 5, board1));
		
		String [] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(6, 6, board2));
	}
	static boolean [][] visit;
	static int ans=0;
	public static int solution(int m, int n, String[] board) {
		ans = 0;
		char [][] cboard = new char[m][n];
		for(int i=0;i<m;i++) {
			cboard[i] = board[i].toCharArray();
		}
		while(game(m, n, cboard)) {
			down(m, n, cboard);
		}
		return ans;
	}
	public static boolean game(int m,int n,char[][] cboard) {
		visit = new boolean [m][n];
		boolean flag = false;
		for(int i=0;i<m-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(cboard[i][j]!='.') {
					if(cboard[i][j]==cboard[i][j+1]&&
						cboard[i][j]==cboard[i+1][j]&&
						cboard[i][j]==cboard[i+1][j+1]) {
						visit[i][j] = visit[i][j+1] = visit[i+1][j] = visit[i+1][j+1] = true;
						flag = true;
					}
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]) {
					cboard[i][j] = '.';
					ans++;
				}
			}
		}
		return flag;
	}
	public static void down(int m,int n,char[][] cboard) {
		for(int i=0;i<n;i++) {
			for(int j=m-2;j>=0;j--) {
				if(cboard[j][i]!='.') {
					int r = j;
					while(++r<m) {
						if(cboard[r][i]!='.') {
							break;
						}
					}
					if(r-1!=j) {
						cboard[r-1][i] = cboard[j][i];
						cboard[j][i] = '.';
					}
				}
			}
		}
	}
}
