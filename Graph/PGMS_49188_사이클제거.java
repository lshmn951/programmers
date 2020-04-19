package programmers;

import java.util.ArrayList;
import java.util.List;

public class PGMS_49188_사이클제거 {
	static List<Integer> [] graph = new List[5001]; 
	static List<Integer> [] child = new List[5001]; // 각 정점을 루트로 하는 서브트리 생성할 리스트
	static int [] discovered  = new int [5001]; // 각 정점의 방문순서를 저장 (back edge 판단 요소)
	static int [] inback = new int [5001]; // 각 정점이 루트인 서브트리에 완전히 포함된 back edge의 수
	static int [] parentback = new int [5001]; // 각 정점이 루트인 서브트리에서 해당 정점의 부모가 목적지인 back edge의 수
	static int [] allback = new int [5001]; // 각 정점이 루트인 서브트리에서 출발하는 모든 back edge의 수
	public static void main(String[] args) {
		int [][] edges1 = {{1,2},{1,3},{2,3},{2,4},{3,4}};
		int [][] edges2 = {{1,2,},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{8,1},{2,7},{3,6}};
		System.out.println(solution(4,edges1));
		System.out.println(solution(8,edges2));

	}
	public static int solution(int n,int[][] edges) {
		// BCC(Biconnected Component), DFS 트리 이용
		int answer =0;
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}
		for(int i=0;i<edges.length;i++) {
			graph[edges[i][0]].add(edges[i][1]);
			graph[edges[i][1]].add(edges[i][0]);
		}
		discovered[1] = 1;
		dfs(1,0);
		for(int i=1;i<=n;i++) {
			// i 를 삭제했을 때
			boolean flag = false;
			for(int ch: child[i]) {
				if(inback[ch]>0) {
					// 자손 노드(ch)가 루트인 서브트리 안에 back edge가 존재하면 사이클 생성 
					flag = true;
				}
				if(allback[ch]-parentback[ch]-inback[ch]>1) {
					// 자손 노드에서 i의 부모 서브트리로 가는 back edge가 2개 이상있으면 사이클 생성
					flag = true;
				}
			}
			if(flag||(edges.length-(n-1))!=allback[i]) {
				// 전체 그래프의 back edge 수와 i노드를 루트로 하는 서브트리의 back edge수가 다르면 사이클 생성
				continue;
			}
			answer+=i;
		}
		
		return answer;
	}
	
	public static void dfs(int cur,int parent) {
		for(int next:graph[cur]) {// 현재 정점과 연결된 다른 정점들 탐색
			if(next!=parent) { // 다음 정점이 부모가 아닐 경우
				if(discovered[next]==0) {
					// tree edge
					child[cur].add(next); // cur가 루트인 서브트리 생성
					discovered[next] = discovered[cur]+1; // 방문 순서 처리
					
					int temp = inback[cur]; // dfs 탐색전 현재 정점을 포함한 서브트리의 back edge 개수 임시 저장
					dfs(next,cur);
					// dfs 탐색후 업데이트된 현재 정점을 포함한 서브트리의 back edge 개수 - 탐색전 back edge 개수 = 
					// 다음 트리에서 현재 정점으로 오는 back edge 개수
					parentback[next] = inback[cur] - temp; 
					
					inback[cur] += inback[next]; // 다음 정점을 루트로 하는 서브트리에 완전히 포함된 back edge 개수를 더해준다.
					
					allback[cur] += allback[next]; // 다음 정점을 루트로 하는 서브트리의 모든 back edge 개수를 더해준다.
				}
				else if(discovered[next]<discovered[cur]) {
					// back edge
					allback[cur]++; // 현재 정점에서 출발하는 back edge 개수 증가
					inback[next]++; // 다음 정점으로 향하는 back edge 개수 증가
				}
			}
		}
	}
	
	
	
	/*
	public static int solution(int n, int[][] edges) {
		//효율성 실패한 코드
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
	*/
}
