package programmers;

public class PGMS_12946_하노이의탑 {

	public static void main(String[] args) {
		int [][] answer = solution(2);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i][0]+" "+answer[i][1]);
		}
	}
	static int [][] arr;
	static int idx;
	public static int[][] solution(int n) {
        int[][] answer = {};
        idx = 0;
        arr = new int [(int)Math.pow(2, n)-1][2];
        hanoi(n,1,2,3);
        answer = arr;
        return answer;
    }
	public static void hanoi(int n,int cur,int emp,int des) {
		if(n==1) {
			arr[idx][0] = cur;
			arr[idx++][1] = des;
		}else {
			hanoi(n-1,cur,des,emp);
			arr[idx][0] = cur;
			arr[idx++][1] = des;
			hanoi(n-1,emp,cur,des);
		}
	}
}
