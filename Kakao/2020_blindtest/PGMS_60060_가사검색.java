package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PGMS_60060_가사검색 {

	public static void main(String[] args) {
		String [] words = {"frodo", "front", "frost", "frozen", "frame", "kakao", "fsbscc"};
		String [] queries = {"fro??", "????o", "fr???", "fro???", "pro?","???ao","a?????","?????z","?????c"};
		int [] answer = solution(words,queries);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int [queries.length];
		
		List<String> []list = new List[100001];//?가 접미사인 경우 탐색할 리스트
		List<String> []reverse = new List[100001];//?가 접두사인 겨우 탐색할 리스트
		for(int i=0;i<100001;i++) {
			list[i] = new ArrayList<String>();
			reverse[i] = new ArrayList<String>();
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<words.length;i++) {
			//List들은 문자열 길이를 인덱스로 생각하고 각 문자열들 저장
			int len = words[i].length();
			list[len].add(words[i]);
			reverse[len].add(rS(words[i]));
		}
		for(int i=0;i<100001;i++) {
			//이분탐색을 위해 정렬
			Collections.sort(list[i]);
			Collections.sort(reverse[i]);
		}
		for(int i=0;i<queries.length;i++) {
			String str = queries[i];
			if(map.containsKey(str)) {
				//중복된 키워드는 맵에서 찾아 빠르게 반환
				answer[i] = map.get(str);
				continue;
			}

			int strlen = str.length();
			int cnt = 0;
			if(list[strlen].size()==0) {
				//words에 키워드의 길이와 같은게 없을 경우 0 을 반환
				answer[i] = 0;
				map.put(str, 0);
				continue;
			}
			boolean first = false;
			boolean all = false;
			int idx;
			String temp;
			if(str.charAt(0)=='?') {
				//?가 접두사
				idx = str.lastIndexOf("?")+1;
				//이분탐색을 위해 문자열을 거꾸로 저장
				temp = rS(str.substring(idx));
				first = true;
				if(idx==str.length()) {
					//키워드가 전부 ?로 이루어진 경우
					all = true;
				}
				idx = strlen-idx;
			}
			else {
				//?가 접미사
				idx = str.indexOf("?");
				temp = str.substring(0,idx);
			}
			if(all) {
				//키워드가 전부 ?로 이루어진 경우 같은 길이의 words 개수 반환
				answer[i] = list[strlen].size();
				map.put(str, answer[i]);
			}
			else {
				int lo_st = 0;
				int lo_ed = list[strlen].size();
				while(lo_st<lo_ed) {
					//해당 길이의 words중 키워드를 만족하는 lower bound를 lo_st에 저장
					int mid = (lo_st+lo_ed)/2;
					String t;
					if(!first) {
						t = list[strlen].get(mid).substring(0,idx);
					}else {
						t = reverse[strlen].get(mid).substring(0,idx);
					}
					if(t.compareTo(temp)>=0) {
						lo_ed = mid;
					}else {
						lo_st = mid+1;
					}
				}
				int hi_st = 0;
				int hi_ed = list[strlen].size();
				while(hi_st<hi_ed) {
					//해당 길이의 words중 키워드를 만족하는 upper bound를 hi_st에 저장
					int mid = (hi_st+hi_ed)/2;
					String t;
					if(!first) {
						t = list[strlen].get(mid).substring(0,idx);
					}else {
						t = reverse[strlen].get(mid).substring(0,idx);
					}
					if(t.compareTo(temp)>0) {
						hi_ed = mid;
					}else {
						hi_st = mid+1;
					}
				}
				cnt = hi_st-lo_st;//upper_bound - lower_bound가 키워드를 만족하는 words의 개수
				
				answer[i] = cnt;
				map.put(str, cnt);
				System.out.println(temp+" "+hi_st+" "+lo_st);

			}
		}
		return answer;
	}
	public static String rS(String s) {
		//문자열 거꾸로 반전 후 반환
		return (new StringBuffer(s)).reverse().toString();
	}
}
