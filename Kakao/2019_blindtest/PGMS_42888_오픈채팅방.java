package programmers;

import java.util.HashMap;
import java.util.Map;

public class PGMS_42888_오픈채팅방 {

	public static void main(String[] args) {
		String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan","Enter uid1235 Muzi"};
		String [] answer = solution(record);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
	public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<String, String>();
        int cnt=0;
        for(int i=0;i<record.length;i++) {
        	String [] temp = record[i].split(" ");
        	if(temp[0].equals("Enter")) {
        		map.put(temp[1], temp[2]);
        	}else if(temp[0].equals("Change")) {
        		map.put(temp[1], temp[2]);
        		cnt++;
        	}
        }
        answer = new String [record.length-cnt];
        int idx = 0;
        for(int i=0;i<record.length;i++) {
        	String [] temp = record[i].split(" ");
        	if(temp[0].equals("Enter")) {
        		answer[idx++] = map.get(temp[1])+"님이 들어왔습니다.";
        	}else if(temp[0].equals("Leave")) {
        		answer[idx++] = map.get(temp[1])+"님이 나갔습니다.";
        	}
        }
        return answer;
    }
}
