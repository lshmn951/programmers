package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 여행경로 {

	public static void main(String[] args) {

		String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}
	static boolean [] visit;
	static String [] temp;
	public static String[] solution(String[][] tickets) {
		String[] answer = new String[tickets.length+1];
		temp = new String[tickets.length+1];
		visit = new boolean[tickets.length];
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) {
					return o1[1].compareTo(o2[1]);
				}
				else {
					return o1[0].compareTo(o2[0]);
				}

			}
		});
		dfs("ICN",0,tickets);
		return temp;
	}
	public static boolean dfs(String str,int k,String[][] tickets) {
		if(k==tickets.length) {
			temp[k] = str;
			return true;
		}

		for(int i=0;i<tickets.length;i++) {
			if(!visit[i] && tickets[i][0].equals(str)) {
				visit[i] = true;
				temp[k] = str;
				if(dfs(tickets[i][1],k+1,tickets)) {
					
					return true;
				}
				visit[i] = false;
			}
		}
		return false;
	}
}
