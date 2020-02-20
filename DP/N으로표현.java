package programmers;

import java.util.ArrayList;
import java.util.List;

public class N으로표현 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5,12));
		System.out.println(solution(2,11));
	}
	static List<Integer> []list = new List[9];
	static int []NN = new int[9];
	public static int solution(int N, int number) {
        int answer = -1;
        for(int i=0;i<9;i++) {
        	list[i] = new ArrayList<>();
        }
        int ten = 1;
        for(int i=1;i<=8;i++,ten*=10) {
        	NN[i] = ten*N + NN[i-1];
        }
        list[1].add(N);
        if(N==number) {
        	return 1;
        }
        for(int i=2;i<=8;i++) {
        	list[i].add(NN[i]);
        	for(int j=1;j<=i/2;j++) {
        		for(int q=0;q<list[j].size();q++) {
	        		for(int k=0;k<list[i-j].size();k++) {
	        			list[i].add(list[j].get(q)+list[i-j].get(k));
	        			list[i].add(list[j].get(q)-list[i-j].get(k));
	        			list[i].add(list[j].get(q)*list[i-j].get(k));
	        			if(list[i-j].get(k)!=0)
	        				list[i].add(list[j].get(q)/list[i-j].get(k));
	        			list[i].add(list[i-j].get(k)-list[j].get(q));
	        			if(list[j].get(q)!=0)
	        				list[i].add(list[i-j].get(k)/list[j].get(q));
	        		}
        		}
        	}
        	
        	for(int j=0;j<list[i].size();j++) {
        		if(list[i].get(j)==number) {
        			return i;
        		}
        	}
        }
        return answer;
    }
}
