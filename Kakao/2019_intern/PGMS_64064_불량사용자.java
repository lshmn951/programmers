package programmers;

import java.util.Arrays;

public class PGMS_64064_불량사용자 {

	public static void main(String[] args) {
		String [] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] banned_id1 = {"fr*d*", "abc1**"};
		System.out.println(solution(user_id1, banned_id1));
		
		String [] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] banned_id2 = {"*rodo", "*rodo", "******"};
		System.out.println(solution(user_id2, banned_id2));
		
		String [] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(solution(user_id3, banned_id3));

	}
	static int ans = 0;
	public static int solution(String[] user_id, String[] banned_id) {
        ans = 0;
        combination(user_id, banned_id.length, 0, 0, new String[banned_id.length], banned_id);
        return ans;
    }
	public static void combination(String[] user_id,int size,int k,int before,String []temp,String []banned_id) {
		if(k==size) {
			if(check(size,0,new boolean[size], temp, banned_id)) {
				ans++;
			}
		}else {
			for(int i=before;i<user_id.length;i++) {
				temp[k] = user_id[i];
				combination(user_id, size, k+1, i+1, temp, banned_id);
			}
		}
	}
	public static boolean check(int size,int k,boolean [] visit,String[] temp, String [] banned_id) {
		if(size==k) {
			return true;
		}
		else {
			for(int j=0;j<banned_id.length;j++) {
				if(!visit[j] && strcheck(temp[k],banned_id[j])) {
					visit[j] = true;
					if(check(size, k+1, visit, temp, banned_id)) {
						return true;
					};
					visit[j] = false;
				}
			}
		}
		return false;
	}
	public static boolean strcheck(String str1,String str2) {
		if(str1.length()!=str2.length()) {
			return false;
		}else {
			for(int i=0;i<str1.length();i++) {
				if(str2.charAt(i)!='*' && str1.charAt(i)!=str2.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
