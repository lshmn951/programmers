package programmers;

public class 타겟넘버 {

	class Solution {
		int cnt;
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        cnt =0;
	        dfs(0,numbers,0,target);
	        return cnt;
	    }
	    public void dfs(int k,int[] numbers,int temp,int target) {
			if(k==numbers.length) {
				if(temp==target) {
					cnt++;
				}
				return;
			}
			else {
				dfs(k+1,numbers,temp+numbers[k],target);
				dfs(k+1,numbers,temp-numbers[k],target);
				
			}
		}
	}
	
}
