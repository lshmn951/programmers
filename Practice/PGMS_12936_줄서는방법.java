package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGMS_12936_줄서는방법 {
	
	public static void main(String[] args) {
		int [] ans = solution(3, 5);
		System.out.println(Arrays.toString(ans));

	}
	public static int[] solution(int n, long k) {
        int [] answer = new int [n];
        List<Integer> list = new ArrayList<Integer>();
        int idx = 0;
        long fac = 1;
        for(int i=1;i<=n;i++) {
        	fac *= i;
        	list.add(i);
        }
        k--;
        while(idx<n) {
        	fac /= (n-idx);
        	int temp = (int)(k/fac);
        	answer[idx++] = list.remove(temp);
        	k %= fac;
        }
        return answer;
    }
	
}
