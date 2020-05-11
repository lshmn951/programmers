package programmers;

public class PGMS_12979_기지국설치 {

	public static void main(String[] args) {
		System.out.println(solution(11, new int [] {4,11 }, 1));
		System.out.println(solution(16, new int [] {9 }, 2));

	}
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = 1+2*w;
        int size = stations.length;
        if(stations[0]-w>1) {
        	int front = stations[0]-w-1;
        	answer += (front+(len-1))/len;
        }
        if(stations[size-1]+w<n) {
        	int back = n-(stations[size-1]+w);
        	answer += (back+(len-1))/len;
        }
        for(int i=0;i<size-1;i++) {
        	int interval = (stations[i+1]-w)-(stations[i]+w);
        	if(interval-1>0) {
        		answer += (interval-1+(len-1))/len;
        	}
        }
        return answer;
    }
}
