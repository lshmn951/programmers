import java.util.LinkedList;
import java.util.Queue;

class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> truck_w = new LinkedList<Integer>();
	        Queue<Integer> time = new LinkedList<Integer>();
	        int cur = 0;
	        int idx = 0;
	        int i = 0;
	        while(true) {
	        	i++;
	        	if(!time.isEmpty()) {
	        		if(i==time.peek()+bridge_length) {
		        		if(idx==truck_weights.length && time.size()==1) {
		        			answer = bridge_length+time.poll();
		        			return answer;
		        		}
		        		time.poll();
		        		cur -= truck_w.poll();
	        		}
	        	}
	        	if(idx<truck_weights.length && cur+truck_weights[idx]<=weight) {
		        	cur +=truck_weights[idx];
	    			time.add(i);
	    			truck_w.add(truck_weights[idx++]);
	        	}
	        }
	    }
	}