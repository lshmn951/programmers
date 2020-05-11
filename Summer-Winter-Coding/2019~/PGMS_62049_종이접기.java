package programmers;

import java.util.Arrays;

public class PGMS_62049_종이접기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(1)));
		System.out.println(Arrays.toString(solution(2)));
		System.out.println(Arrays.toString(solution(3)));
		System.out.println(Arrays.toString(solution(4)));

	}
	public static int[] solution(int n) {
        int[] answer = {};
        if(n==1) {
        	answer = new int []{0};
        }else if(n==2) {
        	answer = new int [] {0,0,1};
        }
        else {
        	String str = recur(true,n)+"0"+recur(false,n);
        	answer = new int [str.length()];
        	for(int i=0;i<str.length();i++) {
        		answer[i] = str.charAt(i)-'0';
        	}
        }
        return answer;
    }
	public static String recur(boolean pre,int n) {
		StringBuilder sb = new StringBuilder();
		if(n==2 && pre) {
			return "0";
		}
		else if(n==2 && !pre) {
			return "1";
		}
		else if(pre){
			sb.append(recur(true,n-1));
			sb.append("0");
			sb.append(recur(false,n-1));
			return sb.toString();
		}
		else {
			sb.append(recur(true,n-1));
			sb.append("1");
			sb.append(recur(false,n-1));
			return sb.toString();
		}
		
	}
}
