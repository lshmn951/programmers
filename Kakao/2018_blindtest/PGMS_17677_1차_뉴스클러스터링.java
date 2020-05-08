package programmers;

import java.util.ArrayList;
import java.util.List;

public class PGMS_17677_1차_뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
	public static int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for(int i=0;i<str1.length()-1;i++) {
			if(Character.isAlphabetic(str1.charAt(i))&&Character.isAlphabetic(str1.charAt(i+1))) {
				String temp = "";
				temp += str1.charAt(i);
				temp += str1.charAt(i+1);
				list1.add(temp);
			}
		}
		for(int i=0;i<str2.length()-1;i++) {
			if(Character.isAlphabetic(str2.charAt(i))&&Character.isAlphabetic(str2.charAt(i+1))) {
				String temp = "";
				temp +=str2.charAt(i);
				temp +=str2.charAt(i+1);
				list2.add(temp);
			}
		}
		int total = list1.size()+list2.size();
		if(total==0) {
			return 65536;
		}
		int cnt = 0;
		for(int i=0;i<list1.size();i++) {
			String s1 = list1.get(i);
			for(int j=0;j<list2.size();j++) {
				String s2 = list2.get(j);
				if(s1.equals(s2)) {
					list1.remove(i);
					list2.remove(j);
					cnt++;
					i--;
					break;
				}
			}
		}
		answer = (int)Math.floor(65536*((double)cnt/(total-cnt)));
		return answer;
	}
}
