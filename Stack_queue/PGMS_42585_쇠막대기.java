package programmers;

public class PGMS_42585_쇠막대기 {

	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));

	}
	
	public static int solution(String arrangement) {
		int answer = 0;
	    int cur = 0;
	    for(int i=0;i<arrangement.length();i++){
	        if(arrangement.charAt(i)=='(' && arrangement.charAt(i+1)==')'){
	            i++;
	            answer+=cur;
	        }
	        else if(arrangement.charAt(i)=='('){
	            cur++;
	            answer++;
	        }
	        else if(arrangement.charAt(i)==')'){
	            cur--;
	        }
	    }
	    return answer;
    }
}
