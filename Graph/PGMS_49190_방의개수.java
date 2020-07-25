package programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PGMS_49190_방의개수 {
	public static void main(String[] args) {
		int [] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
		System.out.println(solution(arrows));
		int [] arrow2 = {0,1,0,1,0,1,0,1,0,1,0,1,0,1};
		System.out.println(solution(arrow2));
		int [] arrow3 = {4,2,7,4,2,7};
		System.out.println(solution(arrow3));
		int [] arrow4 = {2,5,2,7};
		System.out.println(solution(arrow4));
	}
	public static int solution(int[] arrows) {
		int answer = 0;
		int [][] dirs8 = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
		Set<Point> visit = new HashSet<>();
		Set<Point> dir = new HashSet<>();
		int x = 0;
		int y = 0;
		visit.add(new Point(0,0,-1));
		for(int i=0;i<arrows.length;i++) {
			for(int j=0;j<2;j++) {
				int nx = x + dirs8[arrows[i]][0];
				int ny = y + dirs8[arrows[i]][1];
				Point tempp = new Point(x,y,arrows[i]);
				Point visitc = new Point(nx,ny,-1);
				Point tempn = new Point(nx,ny,(arrows[i]+4)%8);
				if(!visit.add(visitc)) {
					if(!dir.contains(tempp)||!dir.contains(tempn)) {
						answer++;
					}
				}
				dir.add(tempn);
				dir.add(tempp);
				x = nx;
				y = ny;
			}
		}
		return answer;
	}

	static class Point{
		int x,y;
		int d;

		public Point(int x, int y,int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x,y,d);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (d != other.d)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}
