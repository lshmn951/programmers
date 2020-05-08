package programmers;

import java.util.LinkedHashSet;
import java.util.Set;

public class PGMS_17680_1차_캐시 {

	public static void main(String[] args) {
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(3, cities1));

		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(3, cities2));
		
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(2, cities3));
		
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(5, cities4));
		
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		System.out.println(solution(2, cities5));
		
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(0, cities6));
		
	}
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		if(cacheSize==0) {
			return 5*cities.length;
		}
		for(int i=0;i<cities.length;i++) {
			cities[i] = cities[i].toLowerCase();
		}
		Set<String> set = new LinkedHashSet<String>();
		for(int i=0;i<cities.length;i++) {
			String str = cities[i];
			if(set.contains(str)) {
				// LRU 는 캐시에 있더라도 사용되면 최신이라고 판단해줘야 함
				set.remove(str);
				set.add(str);
				answer++;
			}else {
				if(set.size()<cacheSize) {
					set.add(str);
				}else {
					for(String temp:set) {
						set.remove(temp);
						break;
					}
					set.add(str);
				}
				answer+=5;
			}
		}
		return answer;
	}
}
