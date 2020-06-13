package programmers;

public class PGMS_12899_124나라의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));

	}
	public static String solution(int n) {
		String answer = "";
	    int temp;
	    while(n>0){
	        temp = n%3;
	        n = n/3;
	        if(temp==0)
	            n = n-1;
	        answer = "412".charAt(temp) + answer;
	    }
	    return answer;
    }
}
