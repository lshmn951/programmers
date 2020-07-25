package kakao2020_internship;

public class PGMS_67256_키패드누르기 {

	public static void main(String[] args) {
		int [] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		System.out.println(solution(numbers, "right"));
		
		int [] numbers1 = {7,0,8,2,8,3,1,5,7,6,2};
		System.out.println(solution(numbers1, "left"));
		
		int [] numbers2 = {1,2,3,4,5,6,7,8,9,0};
		System.out.println(solution(numbers2, "right"));
	}
	static String answer;
	static Hand left;
	static Hand right;
	public static String solution(int[] numbers, String hand) {
        answer = "";
        left = new Hand(0,0);
        right = new Hand(2,0);
        for(int i=0;i<numbers.length;i++) {
        	if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
        		answer+="L";
        		left.x = 0;
        		left.y = 3-numbers[i]/3;
        	}else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
        		answer+="R";
        		right.x = 2;
        		right.y = 4-numbers[i]/3;
        	}else if(numbers[i]==2) {
        		move(1, 3, hand);
        	}else if(numbers[i]==5) {
        		move(1, 2, hand);
        	}else if(numbers[i]==8) {
        		move(1, 1, hand);
        	}else if(numbers[i]==0) {
        		move(1, 0, hand);
        	}
        }
        
        return answer;
    }
	public static class Hand{
		int x;
		int y;
		public Hand(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int distance(int x,int y,Hand h) {
		return Math.abs(h.x-x)+Math.abs(h.y-y);
	}
	public static void move(int x,int y,String hand) {
		int ld = distance(x, y, left);
		int rd = distance(x, y, right);
		if(ld<rd) {
			answer+="L";
			left.x=x;
			left.y=y;
		}else if(ld>rd) {
			answer+="R";
			right.x=x;
			right.y=y;
		}else {
			if(hand.equals("left")) {
				answer+="L";
				left.x=x;
				left.y=y;
			}else {
				answer+="R";
				right.x=x;
				right.y=y;
			}
		}
	}
}
