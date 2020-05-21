package programmers;

import java.util.HashSet;
import java.util.Set;

public class PGMS_12981_영어끝말잇기 {

	public static void main(String[] args) {
		String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int [] answer1 = solution(3, words1);
		System.out.println(answer1[0]+" "+answer1[1]);
		
		String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int [] answer2 = solution(5, words2);
		System.out.println(answer2[0]+" "+answer2[1]);
		
		String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		int [] answer3 = solution(2, words3);
		System.out.println(answer3[0]+" "+answer3[1]);
	}
	public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int [] people = new int [n];
        Set<String> check = new HashSet<String>();
        int idx = 1;
        people[0]++;
        String before = words[0];
        check.add(before);
        for(int i=1;i<words.length;i++,idx=(idx+1)%n) {
        	people[idx]++;
        	if(before.charAt(before.length()-1)!=words[i].charAt(0)) {
        		answer[0] = idx+1;
        		answer[1] = people[idx];
        		break;
        	}
        	if(!check.add(words[i])) {
        		answer[0] = idx+1;
        		answer[1] = people[idx];
        		break;
        	}
        	before = words[i];
        }
        return answer;
    }
}
