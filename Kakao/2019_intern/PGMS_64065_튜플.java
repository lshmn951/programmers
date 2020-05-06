package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class PGMS_64065_튜플 {

	public static void main(String[] args) {
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] result1 = solution(s1);
		System.out.println(Arrays.toString(result1));
		
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		int[] result2 = solution(s2);
		System.out.println(Arrays.toString(result2));
		
		String s3 = "{{20,111},{111}}";
		int[] result3 = solution(s3);
		System.out.println(Arrays.toString(result3));
		
		String s4 = "{{123}}";
		int[] result4 = solution(s4);
		System.out.println(Arrays.toString(result4));

		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] result5 = solution(s5);
		System.out.println(Arrays.toString(result5));
	}
	public static int[] solution(String s) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<String, Integer>();

        PriorityQueue<Nums> pq = new PriorityQueue<>();
        int si=0;
        for(int i=0;i<s.length();i++) {
        	if(Character.isDigit(s.charAt(i))) {
        		String num = "";
        		si = i;
        		while(Character.isDigit(s.charAt(i))) {
        			i++;
        		}
        		num = s.substring(si, i);
        		if(map.containsKey(num)) {
        			map.put(num, map.get(num)+1);
        		}else {
        			map.put(num, 1);

        		}
        	}
        }
        for(String key : map.keySet()) {
        	pq.add(new Nums(Integer.parseInt(key),map.get(key)));
        }
        answer = new int [pq.size()];
        int idx=0;
        while(!pq.isEmpty()) {
        	answer[idx++] = pq.poll().num;
        }
        return answer;
    }
	public static class Nums implements Comparable<Nums>{
		int num;
		int cnt;
		public Nums(int num,int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Nums o) {
			if(this.cnt>o.cnt) {
				return -1;
			}else if(this.cnt<o.cnt) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	
	// 깔끔한 답안? 코드
	public int[] solution1(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
