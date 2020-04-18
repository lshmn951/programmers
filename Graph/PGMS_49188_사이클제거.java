package programmers;


public class PGMS_49188_사이클제거 {

	public static void main(String[] args) {
		int [][] edges1 = {{1,2},{1,3},{2,3},{2,4},{3,4}};
		int [][] edges2 = {{1,2,},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{8,1},{2,7},{3,6}};
		System.out.println(solution(4,edges1));
		System.out.println(solution(8,edges2));

	}

	public static int solution(int n, int[][] edges) {
		int answer = 0;
		int size = edges.length;
		int [] p = new int [n+1];
		int [] copy = new int[n+1];
		for(int i=0;i<=n;i++) {
			p[i] = i;
		}
		for(int i=1;i<=n;i++) {
			copy = p.clone();
			boolean flag = true;
			for(int j=0;j<edges.length;j++) {
				if(edges[j][0]==i||edges[j][1]==i) {
					continue;
				}
				if(!isGroup(edges[j][0],edges[j][1],copy)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				answer +=i;
			}
		}
		return answer;
	}
	public static int find(int x,int []p) {
		if(p[x]==x) {
			return x;
		}
		else {
			return p[x] = find(p[x],p);
		}
	}
	public static boolean isGroup(int x,int y,int []p) {
		int u = find(x,p);
		int v = find(y,p);
		
		if(u==v) {
			return false;
		}
		p[v] = p[u];
		return true;
	}
}
