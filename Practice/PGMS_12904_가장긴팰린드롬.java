package programmers;

public class PGMS_12904_가장긴팰린드롬 {

	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abacde"));

	}
	public static int solution(String s)
    {
        int answer = 1;
        int size = s.length();
        char [] arr = s.toCharArray();
        boolean [][] dp = new boolean [size][size]; // dp[i][j] 는 i~j사이의 문자열이 팰린드롬이면 true
        
        for(int i=0;i<size-1;i++) {
        	dp[i][i] = true; // 한 글자
        	if(arr[i]==arr[i+1]) { // 두 글자가 팰린드롬
        		dp[i][i+1] = true;
        		answer = 2;
        	}
        }
        dp[size-1][size-1] = true;
        
        for(int i=2;i<size;i++) {
        	for(int j=0;j<size-i;j++) {
        		int k = i+j;
        		if(arr[j]==arr[k]&&dp[j+1][k-1]) { // j+1~k-1사이의 문자열이 팰린드롬이고 j와 k의 문자가 같다면
        			dp[j][k] = true; // j~k 사이의 문자열도 팰린드롬
        			answer = i+1; // 정답은 팰린드롬 문자열의 길이(i가 증가하므로 가장 긴 팰린드롬이 저장됨)
        		}
        	}
        }
       
        return answer;
    }
}
