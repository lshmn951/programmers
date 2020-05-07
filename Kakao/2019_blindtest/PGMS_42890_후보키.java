package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PGMS_42890_후보키 {

	public static void main(String[] args) {
		String [][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
		System.out.println(solution(relation));
		
		String [][] test = {{"a","b","c"},{"1","b","c"},{"a","b","4"},{"a","5","c"}};
		System.out.println(solution(test));
		
		String [][] test2 = {{"a","1","4"},{"2","1","5"},{"a","2","4"}};
		System.out.println(solution(test2));
	}
	static List<Integer> visit; 
	public static int solution(String[][] relation) {
		visit = new ArrayList<Integer>();
        for(int i=1;i<=relation[0].length;i++) {
        	combination(relation, i, 0, 0, new int [i]);
        }
        for(int i=0;i<visit.size();i++) {
        	// 최소성을 만족하는 것들을 골라냄
        	int cur = visit.get(i);
        	for(int j=i+1;j<visit.size();j++) {
        		int next = visit.get(j);
        		if((cur & next)==cur) {
        			visit.remove(j);
        			j--;
        		}
        	}
        }
        return visit.size();
    }
	public static void combination(String[][] relation,int r,int k,int before,int [] temp) {
		// 부분 집합을 뽑아내는 함수
		if(r==k) {
			if(check(temp,relation)) {
				// 유일성을 만족하면 슈퍼키로 저장
				int sum = 0;
				for(int i=0;i<k;i++) {
					sum += (1<<temp[i]);
				}
				visit.add(sum);
			}
		}else {
			for(int i=before;i<relation[0].length;i++) {
				temp[k] = i;
				combination(relation, r, k+1, i+1, temp);
			}
		}
	}
	public static boolean check(int[]temp,String[][] relation) {
		// 유일성을 만족하는지 체크
		Set<String> set = new HashSet<String>();
		for(int i=0;i<relation.length;i++) {
			String str ="";
			for(int j=0;j<temp.length;j++) {
				str += relation[i][temp[j]];
			}
			if(!set.add(str)) {
				return false;
			}
		}
		return true;
	}
}
