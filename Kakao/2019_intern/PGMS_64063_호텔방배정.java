package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGMS_64063_호텔방배정 {

	public static void main(String[] args) {
		long [] room_number = {1,3,4,1,3,1};
		long [] answer = solution(10, room_number);
		System.out.println(Arrays.toString(answer));

	}
	static Map<Long, Long> map = new HashMap<Long, Long>();
	public static long[] solution(long k, long[] room_number) {
        long[] answer = new long [room_number.length];
        for(int i=0;i<room_number.length;i++) {
        	long room  = room_number[i];
        	if(!map.containsKey(room)) {
        		answer[i] = room;
        		map.put(room, find(room+1));
        	}else {
        		long next = find(room);
        		answer[i] = next;
        		map.put(next,find(next+1));
        	}
        }
        return answer;
    }
	public static long find(long x) {
		if(!map.containsKey(x)) {
			return x;
		}else {
			map.replace(x, find(map.get(x)));
			return map.get(x);
		}
	}
}
