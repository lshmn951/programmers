package programmers;

public class PGMS_49994_방문길이 {

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));

	}
	public static int solution(String dirs) {
        int answer = 0;
        int [][][][]map = new int [11][11][11][11];
        int x = 5;
        int y = 5;
        for(int i=0;i<dirs.length();i++) {
        	char ch = dirs.charAt(i);
        	int r=x;
        	int c=y;
        	if(ch=='U') {
        		r--;
        	}else if(ch=='D') {
        		r++;
        	}else if(ch=='R') {
        		c++;
        	}else if(ch=='L') {
        		c--;
        	}
        	if(r<0||c<0||r>10||c>10) {
        		continue;
        	}
        	map[x][y][r][c]=1;// (x,y)좌표에서 (r,c)좌표로 가는 길 표시
        	map[r][c][x][y]=1;// (r,c)좌표에서 (x,y)좌표로 가는 길 표시
        	x=r;y=c;
        }
        for(int i=0;i<11;i++) {
        	for(int j=0;j<11;j++) {
        		for(int q=0;q<11;q++) {
        			for(int w=0;w<11;w++) {
        				if(map[i][j][q][w]==1) {
        					answer++;
        				}
        			}
        		}
        	}
        }
        return answer/2; // 양 방향으로 표시 해줬으므로 2로 나눠준다.
    }
}
