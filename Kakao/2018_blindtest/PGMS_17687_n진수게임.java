package programmers;

public class PGMS_17687_n진수게임 {
	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1));
		System.out.println(solution(16, 16, 2, 1));
		System.out.println(solution(16, 16, 2, 2));
	}
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String temp = "";
        for(int i=0;temp.length()<=t*m;i++) {
        	temp += Integer.toString(i, n);
        }
        for(int i=p-1;answer.length()<t;i+=m) {
        	answer+=temp.charAt(i);
        }
        return answer.toUpperCase();
    }
}
