package programmers;

public class PGMS_12900_2xn타일링 {

	
	public static void main(String[] args) {
		System.out.println(solution(4));

	}
	
	static final int mod = 1000000007;
	
	public static int solution(int n) {
        int [] arr = new int [n+1];
        arr[0] = arr[1] = 1;
        for(int i=2;i<=n;i++) {
        	arr[i] = (arr[i-1]%mod+arr[i-2]%mod)%mod;
        }
        
        return arr[n];
    }
}
