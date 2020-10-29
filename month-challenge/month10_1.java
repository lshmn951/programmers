package monthchallenge;

public class month10_1 {
	public static void main(String[] args) {
		solution(45);
	}
	public static int solution(int n) {
        int answer = 0;
        StringBuilder num = new StringBuilder(Integer.toString(n, 3));
        String reverse = num.reverse().toString();
        answer = Integer.parseInt(reverse,3);
        return answer;
    }
}
