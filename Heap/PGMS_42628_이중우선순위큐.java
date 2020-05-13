package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PGMS_42628_이중우선순위큐 {

	public static void main(String[] args) {
		String [] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int [] ans = solution(operations1);
		System.out.println(ans[0]+" "+ans[1]);
		
		String [] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int [] ans2 = solution(operations2);
		System.out.println(ans2[0]+" "+ans2[1]);

	}
	public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pqf = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqb = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=0;i<operations.length;i++) {
        	char oper = operations[i].charAt(0);
        	String num = operations[i].substring(2);
        	if(oper=='I') {
        		pqf.add(Integer.parseInt(num));
        		pqb.add(Integer.parseInt(num));
        	}else {
        		if(!pqf.isEmpty()) {
	        		if(num.equals("1")) {
	        			int d = pqb.poll();
	        			pqf.remove(d);
	        		}else {
	        			int d = pqf.poll();
	        			pqb.remove(d);
	        		}	
        		}
        	}
        }
        if(!pqf.isEmpty()) {
        	answer[0] = pqb.poll();
        	answer[1] = pqf.poll();
        }
        return answer;
    }
}
