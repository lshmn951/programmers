package programmers;

public class 숫자야구 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] baseball = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
		System.out.println(solution(baseball));
	}
	public static int solution(int[][] baseball) {
        int answer = 0;
        boolean b;
        for(int i=123;i<987;i++) {
        	String temp = Integer.toString(i);
        	b = true;
        	if(temp.charAt(0)==temp.charAt(1)||temp.charAt(0)==temp.charAt(2)||temp.charAt(1)==temp.charAt(2)) {
        		continue;
        	}
        	if(temp.contains("0")) {
        		continue;
        	}
        	for(int j=0;j<baseball.length;j++) {
        		if(!check(temp,Integer.toString(baseball[j][0]),baseball[j][1],baseball[j][2])) {
        			b= false;
        			break;
        		}
        	}
        	if(b) {
        		answer++;
        	}
        }
        return answer;
    }
	public static boolean check(String src,String str,int stc,int bc) {
		int strike=0;
		int ball=0;
		for(int i=0;i<3;i++) {
			if(src.charAt(i)==str.charAt(i)) {
				strike++;
			}
		}
		if(src.charAt(0)==str.charAt(1) || src.charAt(0)==str.charAt(2)) {
			ball++;
		}
		if(src.charAt(1)==str.charAt(0) || src.charAt(1)==str.charAt(2)) {
			ball++;
		}
		if(src.charAt(2)==str.charAt(1) || src.charAt(2)==str.charAt(0)) {
			ball++;
		}
		if(strike==stc && ball==bc) {
			return true;
		}
		else {
			return false;
		}
	}
}
