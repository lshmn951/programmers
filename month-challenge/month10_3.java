package monthchallenge;

import java.util.ArrayList;
import java.util.List;

public class month10_3 {
	public static void main(String[] args) {
		int [][] edges = {{1,2},{2,3},{3,4}};
		System.out.println(solution(4, edges));
	}
	static List<Integer> [] graph; 
	static boolean [] visit;
	static int maxV;
	static int maxL;
	public static int solution(int n, int[][] edges) {
        int answer = 0;
        visit = new boolean [n+1];
        maxV = 0;
        maxL = 0;
        graph = new List[n+1];
        for(int i=0;i<=n;i++) {
        	graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++) {
        	int s = edges[i][0];
        	int e = edges[i][1];
        	graph[s].add(e);
        	graph[e].add(s);
        }
        int a = dfs(1,0);
        visit = new boolean [n+1];
        maxV = 0;
        maxL = 0;
        int b = dfs(a,0);
        visit = new boolean [n+1];
        visit[b] = true;
        maxV = 0;
        maxL = 0;
        dfs(a,0);
        int c = maxL;
        visit = new boolean [n+1];
        visit[a] = true;
        maxV = 0;
        maxL = 0;
        dfs(b,0);
        int d = maxL;
        answer = Math.max(c, d);
        return answer;
    }
	public static int dfs(int p,int val) {
		visit[p] = true;
		for(int i=0;i<graph[p].size();i++) {
			int next = graph[p].get(i);
			if(!visit[next]) {
				dfs(next,val+1);
			}
		}
		if(maxL<val) {
			maxL = val;
			maxV = p;
		}
		return maxV;
	}
}
