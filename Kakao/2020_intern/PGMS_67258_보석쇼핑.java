package kakao2020_internship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PGMS_67258_보석쇼핑 {

	public static void main(String[] args) {
		String [] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int answer [] = solution(gems1);
		System.out.println(Arrays.toString(answer));
		String [] gems2 = {"AA", "AB", "AC", "AA", "AC"};
		int answer2 [] = solution(gems2);
		System.out.println(Arrays.toString(answer2));
		String [] gems3 = {"XYZ", "XYZ", "XYZ"};
		int answer3 [] = solution(gems3);
		System.out.println(Arrays.toString(answer3));
		String [] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int answer4 [] = solution(gems4);
		System.out.println(Arrays.toString(answer4));
	}
	public static int[] solution(String[] gems) {
        int[] answer = new int [2];
        Map<String, Integer> map = new HashMap<String, Integer>();
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        int idx = 0;
        for(int i=0;i<gems.length;i++) {
        	String str = gems[i];
        	if(!map.containsKey(str)) {
        		map.put(str, idx++);
        	}
        }
        boolean []visit = new boolean [map.size()];
        int cnt = 0;
        int ei = gems.length-1;
        int si = gems.length-1;
        while(true) {
        	String temp = gems[si];
        	int ix = map.get(temp);
        	
        	if(!visit[ix]) {
        		visit[ix] = true;
        		cnt++;
        	}
        	if(cnt==map.size()) {
        		pq.add(new Interval(si+1, ei+1));
        		while(true) {
            		String str = gems[ei];
            		if(check(str,gems,si,ei)) {
            			ei--;
            			pq.add(new Interval(si+1, ei+1));
            		}
            		else {
            			
	            		int i= map.get(str);
	            		visit[i] = false;
	            		cnt--;
	            		break;
            		}
        		}
        	}
        	si--;
        	if(si<0) {
        		break;
        	}
        }
        answer[0] = pq.peek().si;
        answer[1] = pq.peek().ei;
        return answer;
    }
	public static boolean check(String str,String []gems,int si,int ei) {
		for(int i=ei-1;i>=si;i--) {
			if(gems[i].equals(str)) {
				return true;
			}
		}
		return false;
	}
	public static class Interval implements Comparable<Interval>{
		int si;
		int ei;
		public Interval(int si, int ei) {
			this.si = si;
			this.ei = ei;
		}
		@Override
		public int compareTo(Interval o) {
			if(this.ei-this.si<o.ei-o.si) {
				return -1;
			}else if(this.ei-this.si>o.ei-o.si) {
				return 1;
			}else {
				if(this.si<o.si) {
					return -1;
				}else if(this.si>o.si) {
					return 1;
				}else {
					return 0;
				}
			}
		}
		
	}
}
