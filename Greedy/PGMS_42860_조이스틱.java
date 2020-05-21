package programmers;

public class PGMS_42860_조이스틱 {

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
		System.out.println(solution("AAABAAA"));

	}
	public static int solution(String name) {
        int answer = 0;
        int cur = 0;
        int cnt = 0;
        int len = name.length();
        boolean [] visit = new boolean [len];
        for(int i=0;i<len;i++) {
        	if(name.charAt(i)!='A') {
        		cnt++;
        	}
        }
        if(name.charAt(0)=='A') {
        	cnt++;
        }
        while(true) {
        	answer += Math.min(name.charAt(cur)-'A','Z'-name.charAt(cur)+1);
        	visit[cur] = true;
        	cnt--;
        	if(cnt<=0) {
        		break;
        	}
        	int lc=0;
        	int rc=0;
        	int li = cur;
        	int ri = cur;
        	while(name.charAt(li)=='A'||visit[li]) {
        		lc++;
        		li = (li<=0) ? len-1: li-1;
        	}
        	while(name.charAt(ri)=='A'||visit[ri]) {
        		rc++;
        		ri = (ri+1)%len;
        	}
        	if(lc<rc) {
        		answer += lc;
        		cur = li;
        	}else {
        		answer += rc;
        		cur = ri;
        	}
        	
        }
        
        return answer;
    }
}
