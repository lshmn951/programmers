package programmers;

public class PGMS_62048_멀쩡한사각형 {

	public static void main(String[] args) {
		System.out.println(solution(8, 12));

	}
	public static long solution(int w, int h) {
        long answer = 1;
        int temp = gcd(w,h);
        answer = (long)w*h - (long)(w+h-temp);
        return answer;
    }
	public static int gcd(int w,int h) {
		int r=1;
		while(r>0) {
			r=w%h;
			w=h;
			h=r;
		}
		return w;
	}
}
